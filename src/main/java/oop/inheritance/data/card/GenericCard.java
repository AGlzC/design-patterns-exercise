package oop.inheritance.data.card;


public class GenericCard {
    private String account;
    int expirationYear;
    int expirationMonth;
    GenericEntryMode entryMode;


    public enum GenericEntryMode {
        INSERTED,
        SWIPED,
        MANUAL,
        RFID,
        OTHER
    }

    public GenericCard(oop.library.ingenico.model.Card ingenicoCard)
    {
        this.account = ingenicoCard.getAccount();
        this.expirationYear = ingenicoCard.getExpirationDate().getYear();
        this.expirationMonth = ingenicoCard.getExpirationDate().getMonth();
        switch (ingenicoCard.getEntryMode()){
            case INSERTED -> this.entryMode = GenericEntryMode.INSERTED;
            case SWIPED -> this.entryMode = GenericEntryMode.SWIPED;
            case MANUAL -> this.entryMode = GenericEntryMode.MANUAL;
        }
    }

    public GenericCard(oop.library.verifone.model.Card verifoneCard)
    {
        this.account = verifoneCard.getAccount();
        this.expirationYear = verifoneCard.getExpirationDate().getYear();
        this.expirationMonth = verifoneCard.getExpirationDate().getMonth();
        switch (verifoneCard.getEntryMode()){
            case INSERTED -> this.entryMode = GenericEntryMode.INSERTED;
            case SWIPED -> this.entryMode = GenericEntryMode.SWIPED;
            case MANUAL -> this.entryMode = GenericEntryMode.MANUAL;
        }
    }

    public oop.library.ingenico.model.Card getIngenicoCard()
    {
        oop.library.ingenico.model.EntryMode entryMode = oop.library.ingenico.model.EntryMode.MANUAL;

        switch (this.entryMode){
            case INSERTED -> entryMode = oop.library.ingenico.model.EntryMode.INSERTED;
            case SWIPED -> entryMode = oop.library.ingenico.model.EntryMode.SWIPED;
            case MANUAL, RFID, OTHER -> {
            }
        }
        return new oop.library.ingenico.model.Card(this.account,
                new oop.library.ingenico.model.ExpirationDate(this.expirationYear, this.expirationMonth),
                entryMode);
    }

    public oop.library.verifone.model.Card getVerifoneCard()
    {
        oop.library.verifone.model.EntryMode entryMode = oop.library.verifone.model.EntryMode.MANUAL;

        switch (this.entryMode){
            case INSERTED -> entryMode = oop.library.verifone.model.EntryMode.INSERTED;
            case SWIPED -> entryMode = oop.library.verifone.model.EntryMode.SWIPED;
            case MANUAL, RFID, OTHER -> {
            }
        }
        return new oop.library.verifone.model.Card(this.account,
                new oop.library.verifone.model.ExpirationDate(this.expirationYear, this.expirationMonth),
                entryMode);
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }

    public int getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(int expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public GenericEntryMode getEntryMode() {
        return entryMode;
    }

    public void setEntryMode(GenericEntryMode entryMode) {
        this.entryMode = entryMode;
    }
}
