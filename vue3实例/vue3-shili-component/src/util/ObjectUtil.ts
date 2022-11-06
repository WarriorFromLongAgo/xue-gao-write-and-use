function isBlank(input: string): boolean {
  return (
    input === null || input == undefined || input === "" || input.trim() == ""
  );
}

function isEmpty(input: object): boolean {
  if (input === null || input == undefined) {
    return true;
  }
  if (input instanceof Array) {
    return input.length === 0;
  }
  if (input instanceof Map) {
    return input.size === 0;
  }
  if (input instanceof Set) {
    return input.size === 0;
  }
  return false;
}

function isNotEmpty(input: object): boolean {
  return !isEmpty(input);
}

export { isBlank, isEmpty, isNotEmpty };
