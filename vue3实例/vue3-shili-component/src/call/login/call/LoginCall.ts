import {Request} from "@/util/axios/request";

export class LoginCall {
    static async register(/*params: { keywords: string }*/) {
        let newVar = await Request.post(
            "/sysUser/register",
        );
        return newVar;
    }

    static async login(/*params: { keywords: string }*/) {
        let newVar = await Request.post(
            "/sysUser/login",
        );
        return newVar;
    }
}