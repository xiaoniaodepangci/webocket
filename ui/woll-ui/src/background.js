'use strict'

import { app, protocol, BrowserWindow, ipcMain, Menu, dialog } from 'electron'
import { createProtocol } from 'vue-cli-plugin-electron-builder/lib'
import installExtension, { VUEJS_DEVTOOLS } from 'electron-devtools-installer'
import { autoUpdater } from 'electron-updater'
import path from 'path'

const isDevelopment = process.env.NODE_ENV !== 'production'
// Keep a global reference of the window object, if you don't, the window will
// be closed automatically when the JavaScript object is garbage collected.
let win
// Scheme must be registered before the app is ready
protocol.registerSchemesAsPrivileged([
  { scheme: 'app', privileges: { secure: true, standard: true } }
])

// 创建窗口打开应用
async function createWindow() {
  /*隐藏electron创听的菜单栏*/
  // Menu.setApplicationMenu(null)
  // Create the browser window.
  // BrowserWindow.addDevToolsExtension(path.resolve(__dirname, '../devTools/chrome'))
  win = new BrowserWindow({
    minWidth: 1366,
    minHeight: 720,
    webPreferences: {
      nodeIntegration: process.env.ELECTRON_NODE_INTEGRATION
    }
  })
  if (process.env.WEBPACK_DEV_SERVER_URL) {
    await win.loadURL(process.env.WEBPACK_DEV_SERVER_URL)
    if (!process.env.IS_TEST) win.webContents.openDevTools()
  } else {
    createProtocol('app')
    await win.loadURL('app://./index.html')
  }

  win.on('closed', () => {
    win = null
  })
}

// Quit when all windows are closed.
app.on('window-all-closed', () => {
  // On macOS it is common for applications and their menu bar
  // to stay active until the user quits explicitly with Cmd + Q
  if (process.platform !== 'darwin') {
    app.quit()
  }
})

app.on('activate', () => {
  // On macOS it's common to re-create a window in the app when the
  // dock icon is clicked and there are no other windows open.
  if (win === null) {
    createWindow()
  }
})

// This method will be called when Electron has finished
// initialization and is ready to create browser windows.
// Some APIs can only be used after this event occurs.
app.on('ready', async() => {
  if (isDevelopment && !process.env.IS_TEST) {
    // Install Vue Devtools
    console.log('安装vue开发工具')
    try {
      // await installExtension(VUEJS_DEVTOOLS);
      // 新增的：安装vue-devtools
      const { session } = require('electron')
      const path = require('path')

      await session.defaultSession.loadExtension(
        path.join(__dirname, '../devTools/chrome')  //这个是刚刚build好的插件目录
      )
    } catch (e) {

    }
  }
  // win.addDevToolsExtension(path.resolve(__dirname, '../devTools/chrome'));
  createWindow()
  // win.webContents.session.on('will-download', (event, item, webContents) => {
  //   // 设置保存的路径（savePath为上面获取到的路径）
  //   item.setSavePath(path.join(savePath, item.getFilename()))
  //   // 下载信息更新
  //   item.on('updated', (event, state) => {
  //     if (state === 'interrupted') {
  //       // 下载中断
  //     } else if (state === 'progressing') {
  //       if (item.isPaused()) { // 下载停止
  //         // 等待渲染进程请求继续
  //         ipcMain.once('resume', (event) => {
  //           if (item.canResume()) { // 判断是否可以继续
  //             item.resume()
  //           } else {
  //             event.sender.send('resumeCallback', 'cannot resume')
  //           }
  //         })
  //       } else {
  //         // 进度 百分数的整数
  //         let progress = Math.floor(item.getReceivedBytes() / item.getTotalBytes() * 100)
  //         win.webContents.send('progress', progress)
  //       }
  //     }
  //   })
  //   item.once('done', (event, state) => {
  //     if (state === 'completed') {
  //
  //
  //       // 打开下载后所在的文件夹
  //       // shell.showItemInFolder(item.getSavePath())
  //       // 以系统默认方式打开
  //       shell.openItem(item.getSavePath())
  //     } else {
  //
  //     }
  //   })
  // })
})

if (isDevelopment) {
  if (process.platform === 'win32') {
    process.on('message', (data) => {
      if (data === 'graceful-exit') {
        app.quit()
      }
    })
  } else {
    process.on('SIGTERM', () => {
      app.quit()
    })
  }
}
ipcMain.on('checkUpdate', () => {
  //处理更新操作
  const returnData = {
    error: {
      status: -1,
      msg: '更新时发生意外，无法进行正常更新！'
    },
    checking: {
      status: 0,
      msg: '正在检查更新……'
    },
    updateAva: {
      status: 1,
      msg: '正在升级……'
    },
    updateNotAva: {
      status: 2,
      msg: '开始加载程序……'
    }
  }

  //更新连接
  autoUpdater.setFeedURL('https://img-storg.oss-cn-chengdu.aliyuncs.com/')

  //更新错误事件
  autoUpdater.on('error', function(error) {
    console.log(error)
    sendUpdateMessage(returnData.error)
  })

  //检查事件
  autoUpdater.on('checking-for-update', function() {
    sendUpdateMessage(returnData.checking)
  })

  //发现新版本
  autoUpdater.on('update-available', function(info) {
    sendUpdateMessage(returnData.updateAva)
  })

  //当前版本为最新版本
  autoUpdater.on('update-not-available', function(info) {
    setTimeout(function() {
      sendUpdateMessage(returnData.updateNotAva)
    }, 1000)
  })

  //更新下载进度事件
  autoUpdater.on('download-progress', function(progressObj) {
    win.webContents.send('downloadProgress', progressObj)
  })

  //下载完毕
  autoUpdater.on('update-downloaded', function() {
    //退出并进行安装（这里可以做成让用户确认后再调用）
    win.webContents.send('update-downloaded', '下载完成,正在重启')
    setTimeout(function() {
      autoUpdater.quitAndInstall()
    }, 2000)
  })

  //发送消息给窗口
  function sendUpdateMessage(text) {
    win.webContents.send('message', text)
  }

  //发送请求更新
  autoUpdater.checkForUpdates()
})
let savePath
ipcMain.on('download', (event, arg) => {
  let currentWin = BrowserWindow.fromWebContents(event.sender)
  const options = {
    title: '保存至',
    properties: ['openDirectory'] // 本希望只能够选中文件夹，不过在mac上还是会选中文件，这块我没做好
  }
  if (global.electronVersion >= 7) {
    // 7.x
    dialog.showSaveDialog(currentWin, options).then(res => {
      if (res.canceled) return
      savePath = path.dirname(res.filePath)
      // 使用electron提供的下载方式
      currentWin.webContents.downloadURL('下载路径')
    })
  } else {
    // 4.x
    dialog.showSaveDialog(currentWin, options, filePath => {
      if (!filePath) return false
      savePath = path.dirname(filePath)
      currentWin.webContents.downloadURL('下载路径')
    })
  }
})


