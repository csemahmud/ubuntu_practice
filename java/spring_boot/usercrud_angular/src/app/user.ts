/**
 * @author KHAN MAHMUDUL HASAN CSE BD JP
 *
 */
export class User{

    public name: string = "";
    public email: string = "";
    public domain: string = "";
    public age: number = 0;
    public experience: number = 0;
    public salary: number = 0;

    constructor(
        name:string,
        email:string,
        domain:string,
        age:number,
        experience:number,
        salary:number
    ){
        this.name = name;
        this.email = email;
        this.domain = domain;
        this.age = age;
        this.experience = experience;
        this.salary = salary;
    }
}