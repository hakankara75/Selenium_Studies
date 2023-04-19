package day13;

import org.junit.Test;
import com.github.javafaker.Faker;
import utilities.TestBase;

public class C01 extends TestBase {
/*
  Faker objesi olustur
        firstname yazdirin
        lastname yazdirin
        kullanici adi yazdirin
        funny name yazdirin
        meslek ismi yazdirin
        sehir ismi yazdirin
        eyalet ismi yazdirin
        full adres yazdirin
        cep numarasi yazdirin
        email yazdirin
        posta kodu yazdirin
        ratgele 15 haneli bir numara yazdirin
 */
    @Test
    public void test() throws InterruptedException {
        // Faker objesi olustur
        Faker faker=new Faker();
        Faker.instance();

        //firstname yazdirin
        System.out.println(faker.name().firstName());

        //lastname yazdirin
        System.out.println(faker.name().lastName());

        //kullanici adi yazdirin
        System.out.println(faker.name().username());

        //funny name yazdirin
        System.out.println(faker.funnyName().name());

        //meslek ismi yazdirin
        System.out.println(faker.name().title());

        //sehir ismi yazdirin
        System.out.println(faker.address().city());

        //eyalet ismi yazdirin
        System.out.println(faker.address().state());

        //full adres yazdirin
        System.out.println(faker.address().fullAddress());

        //cep numarasi yazdirin
        System.out.println(faker.phoneNumber().cellPhone());

        //email yazdirin
        System.out.println(faker.internet().emailAddress());

        //posta kodu yazdirin
        System.out.println(faker.address().zipCode());

        //ratgele 15 haneli bir numara yazdirin
        System.out.println(faker.number().digits(15));

    }
}
