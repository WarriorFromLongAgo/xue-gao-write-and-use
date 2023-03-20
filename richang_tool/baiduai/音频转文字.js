import fetch from "node-fetch";
import {getAccessToken} from "./获取AccessToken.js";


function main() {
    let accessToken = getAccessToken();
    const options = {
        "method": "POST",
        "headers": {
            "Content-Type": "application/json",
            "Accept": "application/json",
        },
        body: JSON.stringify({
            "speech_url": "222222",
            // 音频格式，["mp3", "wav", "pcm","m4a","amr"]单声道，编码 16bits 位深
            "format": "pcm",
            // 语言类型，[80001（中文语音近场识别模型极速版）, 1737（英文模型）]
            "pid": 80001,
            // 采样率，[16000] 固定值
            "rate": 16000,
        }),
    };
    fetch("https://aip.baidubce.com/rpc/2.0/aasr/v1/create?access_token=" + accessToken, options)
        .then(response => response.json())
        .then(data => {
            console.log("data ===== ", data);
        });
}

main();
