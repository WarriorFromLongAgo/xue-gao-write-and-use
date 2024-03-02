package _0240227_natsio_a

import (
	"github.com/gin-gonic/gin"
	"strconv"
)

func pre() *gin.Engine {
	r := gin.Default()
	r.GET("/ping", func(c *gin.Context) {
		c.JSON(200, gin.H{
			"message": "pong",
		})
	})
	return r
}
func run(router *gin.Engine, port uint) {
	strNum := strconv.Itoa(int(port))
	router.Run(":" + strNum)
}
