interface Person {
  firstName: string;
  lastName: string;
}

interface PersonWithBirthDate extends Person {
  birth: Date;
}

let per1: Person = {
  firstName: "",
  lastName: "",
};

let per2: PersonWithBirthDate = {
  birth: new Date(),
  firstName: "",
  lastName: "",
};

type PersonWithBirthDate2 = Person & { birth: Date };
let per3: PersonWithBirthDate2 = {
  birth: new Date(),
  firstName: "",
  lastName: "",
};

type PersonWithBirthDate3 = {
  userId: Person["firstName"];
  pageTitle: Person["lastName"];
};
let per4: PersonWithBirthDate3 = {
  userId: "",
  pageTitle: "",
};

type PersonWithBirthDate4 = {
  [k in "firstName" | "lastName"]: Person[k]
};
let per5: PersonWithBirthDate4 = {
  firstName: "",
  lastName: "",
};

type PersonWithBirthDate5 = Pick<Person, "firstName" | "lastName">;
let per6: PersonWithBirthDate5 = {
  firstName: "",
  lastName: "",
};



