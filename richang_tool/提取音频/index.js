// let exec = require('child_process').exec;

import { exec } from 'child_process';
let ffmpegPath = "E:\\手机电脑图片备份\\20220703\\ffmpeg-2021-11-25-git-522f577d7e-full_build\\bin\\ffmpeg.exe";
function execute(cmdStr) {
    exec(cmdStr, function (error, stdout, stderr) {
        console.log("stdout === ", stdout);
        if (error) {
            console.error("cmdStr === ", error);
        } else {
            console.log("cmdStr === ", "success");
        }
    });
}

execute("ipconfig");


// ffmpeg -i sample.mp4 -q:a 0 -map a sample.mp3

