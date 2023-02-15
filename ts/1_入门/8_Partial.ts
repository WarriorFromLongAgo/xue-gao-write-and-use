interface Options {
  width: number;
  height: number;
  color: string;
  label: string;
}

interface OptionsUpdate {
  width?: number;
  height?: number;
  color?: string;
  label?: string;
}

class UIWidget {
  constructor(init: Options) {
    /* ... */
  }

  update(options: OptionsUpdate) {
    /* ... */
  }
}


class UIWidgetV2 {
  constructor(init: Options) { /* ... */
  }

  update(options: Partial<Options>) { /* ... */
  }
}
