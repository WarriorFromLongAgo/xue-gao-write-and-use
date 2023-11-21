// package main

// import "fmt"

// func main() {

// }

// func createResource1() error {
// 	return fmt.Errorf("createResource1")
// }

// func destroyResource1() {
// 	fmt.Println("destroyResource1")
// }

// func createResource2() error {
// 	return fmt.Errorf("createResource2")
// }

// func destroyResource2() {
// 	fmt.Println("destroyResource2")
// }

// func createResource3() error {
// 	return fmt.Errorf("createResource3")
// }

// func destroyResource3() {
// 	fmt.Println("destroyResource3")
// }

// func createResource4() error {
// 	return fmt.Errorf("createResource4")
// }

// func destroyResource4() {
// 	fmt.Println("destroyResource4")
// }

// func deferDemo() error {
// 	err := createResource1()
// 	if err != nil {
// 		return ERR_CREATE_RESOURCE1_FAILED
// 	}
// 	err = createResource2()
// 	if err != nil {
// 		destroyResource1()
// 		return ERR_CREATE_RESOURCE2_FAILED
// 	}

// 	err = createResource3()
// 	if err != nil {
// 		destroyResource1()
// 		destroyResource2()
// 		return ERR_CREATE_RESOURCE3_FAILED
// 	}

// 	err = createResource4()
// 	if err != nil {
// 		destroyResource1()
// 		destroyResource2()
// 		destroyResource3()
// 		return ERR_CREATE_RESOURCE4_FAILED
// 	}
// 	return nil
// }

// func deferDemoV2() error {
// 	err := createResource1()
// 	if err != nil {
// 		return ERR_CREATE_RESOURCE1_FAILED
// 	}
// 	defer func() {
// 		if err != nil {
// 			destroyResource1()
// 		}
// 	}()
// 	err = createResource2()
// 	if err != nil {
// 		return ERR_CREATE_RESOURCE2_FAILED
// 	}
// 	defer func() {
// 		if err != nil {
// 			destroyResource2()
// 		}
// 	}()

// 	err = createResource3()
// 	if err != nil {
// 		return ERR_CREATE_RESOURCE3_FAILED
// 	}
// 	defer func() {
// 		if err != nil {
// 			destroyResource3()
// 		}
// 	}()

// 	err = createResource4()
// 	if err != nil {
// 		return ERR_CREATE_RESOURCE4_FAILED
// 	}
// 	return nil
// }
