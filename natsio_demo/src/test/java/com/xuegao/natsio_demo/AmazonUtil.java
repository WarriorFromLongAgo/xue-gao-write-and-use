package com.xuegao.natsio_demo;

public class AmazonUtil {
    /**
     * AWS访问密钥编码
     * <p>
     * 定死的，亚马逊云服务器的东西
     */
    private String accessKeyId = "AKIAUOXZT2VTX5BZRZWW";
    /**
     * AWS访问密钥
     * <p>
     * 定死的，亚马逊云服务器的东西
     */
    private String secretKey = "0QdW4cH5+KN60fY+/B+0bYBMwT/waSPDtCyIn";
    /**
     * IAM职权ARN
     * <p>
     * Amazon商城提供
     */
    private String roleArn = "arn:aws:iam::306539910503:role/admin";
    /**
     * IAM职权名称
     * <p>
     * Amazon商城提供
     */
    private String roleSessionName = "Swe";
    /**
     * clientId
     * <p>
     * Amazon商城提供
     */
    private String clientId = "amzn1.application-oa2-client.00d4e557";
    /**
     * clientSecret
     * <p>
     * Amazon商城提供
     */
    private String clientSecret = "amzn1.oa2-cs.v1.03f511c56292173f94feb7756f8c18bc2c6d";
    /**
     * refreshToken
     * <p>
     * Amazon商城提供
     */
    private String refreshToken = "Atzr|IwEBIL9m3KJLtbN6BvraS9MYARlajHVDZ_LAUExx-sA7WbXJYgbyHfJ4AM23IJdpcx47Z8AEwGG5Q5TG8sw53i9mYc8AEip1AEyPztDURxmwqj8lJ9L0XZF154_H4hiOJf7hp4gnPsIeI_A_agnGgESB97jX1WrC4";
    /**
     * LWA授权服务器的节点地址
     */
    private String lwaEndpoint = "https://api.amazon.com/auth/o2/token";
    /**
     * 区域
     * 根据订单的区域，需要设置不同的地址区号
     */
    private String region = "us-east-1";


}