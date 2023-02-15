interface SaveAction {
  type: "save";
  // ...
}

interface LoadAction {
  type: "load";
  // ...
}

type Action = SaveAction | LoadAction;
type ActionType = "save" | "load"; // Repeated types!


type ActionTypeV2 = Action["type"]; // 类型是 "save" | "load"

// 这里需要注意的是，Action['type'] 返回的是联合类型，而如果我们使用前面介绍的 Pick 工具类型，它会返回一个含有 type 属性的接口：
type ActionRec = Pick<Action, "type">; // {type: "save" | "load"}


