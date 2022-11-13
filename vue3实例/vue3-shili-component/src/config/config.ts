import {isBlank} from "@/util/ObjectUtil";

let apiUrl: string;
let wsUrl: string;
// const publicPath: string = process.env.PUBLIC_PATH;
const useI18n = false;

enum ENV {
    DEV = "dev",
    PRD = "prd",
}

let nowEnv: string = ENV.DEV;

switch (process.env.NODE_ENV) {
    case "development":
        console.log("[xuegao-vue-wechat-demo-ts][config.ts][env=development]");
        apiUrl = "http://127.0.0.1:10000";
        wsUrl = "ws://localhost:61013/ws";
        console.log("[xuegao-vue-wechat-demo-ts][config.ts][apiUrl]", apiUrl);
        console.log("[xuegao-vue-wechat-demo-ts][config.ts][wsUrl]", wsUrl);
        // if (isBlank(apiUrl)) {
        //     console.log(" apiUrl = ", apiUrl);
        //     throw new Error("apiUrl === undefined");
        // }
        // if (isBlank(wsUrl)) {
        //     console.log(" wsUrl = ", wsUrl);
        //     throw new Error("wsUrl === undefined");
        // }
        // if (publicPath === undefined) {
        //   throw new Error("publicPath === undefined");
        // }
        nowEnv = ENV.DEV;
        break;
    case "production":
        apiUrl = "http://127.0.0.1:10000";
        wsUrl = "ws://localhost:61013/ws";
        console.log("[xuegao-vue-wechat-demo-ts][config.ts][apiUrl]", apiUrl);
        console.log("[xuegao-vue-wechat-demo-ts][config.ts][wsUrl]", wsUrl);
        console.log("[xuegao-vue-wechat-demo-ts][config.ts][env=production]");
        nowEnv = ENV.PRD;
        break;
}

export {useI18n, nowEnv, wsUrl, apiUrl, ENV};
