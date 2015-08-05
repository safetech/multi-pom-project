package entity.preference;

import com.github.javafaker.Faker;

public class CribSheet {

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCheatButton() {
        return CheatButton;
    }

    public void setCheatButton(String cheatButton) {
        CheatButton = cheatButton;
    }

    public void setFaker(Faker faker) {
        this.faker = faker;
    }
    public CribSheet() {}
    public CribSheet(Faker faker) {
        this.setFaker(faker);
    }
    private Faker faker;
    public Faker getFaker() {
        return faker;
    }

    private String token = "";
    private String email = "";
    private String transactionid = "";
    private String product = "";
    private String CheatButton = "";

    public void setRandomTokenEmailTransaction() {
        this.setToken(faker.bothify("#?#?#?#?#?#?#?#?#?#?#?#?#?#?#?#?#?#?#?#?#?#?#?#?#?"));
        this.setEmail(String.format("%s.%s@testmail.com", faker.letterify("????"), faker.letterify("????")));
        this.setTransactionid(faker.numerify("##########"));
        this.setProduct("HIP");
    }

}
