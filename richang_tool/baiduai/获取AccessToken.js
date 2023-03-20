import fetch from "node-fetch";
// 应用的API Key，获取方式：https://ai.baidu.com/ai-doc/REFERENCE/Ck3dwjgn3
let client_id = "GFMdBUXUBBW1pa4qSXVG60GM";
// 应用的Secret Key，获取方式：https://ai.baidu.com/ai-doc/REFERENCE/Ck3dwjgn3
let client_secret = "a1WdmhZyqgNdUrSWyF8ktx941lMcHRnR";

// 响应体字段数据结构说明
// 参数名称	参数类型	描述
// access_token	string	要获取的Access Token
// refresh_token	string	该参数忽略
// expires_in	string	Access Token的有效期(秒为单位，有效期30天)
// scope	string	该参数忽略
// session_key	string	该参数忽略
// session_secret	string	该参数忽略

// 错误码	错误描述	HTTP状态码	中文解释
// invalid_client	unknown client id	200	API Key不正确
// invalid_client	Client authentication failed	200	Secret Key不正确

export function getAccessToken() {
    const options = {
        "method": "POST",
        "headers": {
            "Content-Type": "application/json",
        },
    };
    let access_token = "";
    fetch("https://aip.baidubce.com/oauth/2.0/token?client_id=" + client_id + "&client_secret=" + client_secret + "&grant_type=client_credentials", options)
        .then(response => response.json())
        .then(data => {
            console.log("data ===== ", data);
            access_token = data.access_token;
        });
    console.log("access_token ====== ", access_token);
    return access_token;
}

getAccessToken();
