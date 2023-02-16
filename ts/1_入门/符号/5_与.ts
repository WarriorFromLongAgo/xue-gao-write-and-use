interface Person {
  firstName: string;
  lastName: string;
}

type PersonWithBirthDate2 = Person & { birth: Date };

let per3: PersonWithBirthDate2 = {
  birth: new Date(),
  firstName: "",
  lastName: "",
};