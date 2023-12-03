package main

import (
	"encoding/json"
	"fmt"
	"github.com/mitchellh/mapstructure"
	"log"
)

type PersonV2 struct {
	Name string `mapstructure:"username"`
	Age  int
	Job  string
}

type CatV2 struct {
	Name  string
	Age   int
	Breed string
}

func main() {
	datas := []string{`
    { 
      "type": "person",
      "username":"dj",
      "age":18,
      "job": "programmer"
    }
  `,
		`
    {
      "type": "cat",
      "name": "kitty",
      "Age": 1,
      "breed": "Ragdoll"
    }
  `,
		`
    {
      "type": "cat",
      "Name": "rooooose",
      "age": 2,
      "breed": "shorthair"
    }
  `,
	}

	for _, data := range datas {
		var m map[string]interface{}
		err := json.Unmarshal([]byte(data), &m)
		if err != nil {
			log.Fatal(err)
		}

		switch m["type"].(string) {
		case "person":
			var p PersonV2
			mapstructure.Decode(m, &p)
			fmt.Println("person", p)

		case "cat":
			var cat CatV2
			mapstructure.Decode(m, &cat)
			fmt.Println("cat", cat)
		}
	}
}
