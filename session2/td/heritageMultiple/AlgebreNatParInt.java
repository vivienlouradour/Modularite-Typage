package session2.td.heritageMultiple;

import session1.td_corrige.Nat;

public interface AlgebreNatParInt extends Nat{
    @Override
    default public Nat zero(){
        return this.creerNatAvecValeur(0);
    }

    @Override
    default public Nat un(){
        return this.creerNatAvecValeur(1);
    }

    @Override
    default public Nat somme(Nat x){
        return this.creerNatAvecValeur(this.val() + x.val());
    }

    @Override
    default public Nat produit(Nat x){
        return this.creerNatAvecValeur(this.val() * x.val());
    }

    @Override
    default public Nat modulo(Nat x){
        return this.creerNatAvecValeur(this.val() % x.val());
    }

    @Override
    default public Nat div(Nat x){
        return this.creerNatAvecValeur(this.val() / x.val());
    }

    default public String representer(){
        return Integer.toString(this.val());
    }





}
