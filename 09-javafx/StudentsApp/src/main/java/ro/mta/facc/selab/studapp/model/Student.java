package ro.mta.facc.selab.studapp.model;

import javafx.beans.property.*;

public class Student {
    StringProperty nume;
    StringProperty prenume;
    StringProperty grupa;

    IntegerProperty nota_prog;
    IntegerProperty nota_poo;
    IntegerProperty nota_ip;
    FloatProperty medie;


    private void meanCompute()
    {
        this.medie = new SimpleFloatProperty((nota_prog.getValue() + nota_ip.getValue() + nota_poo.getValue()) / 3.0f);
    }

    public Student(String nume, String prenume, String grupa, int nota_prog, int nota_poo, int nota_ip) {
        this.nume = new SimpleStringProperty(nume);
        this.prenume = new SimpleStringProperty(prenume);
        this.grupa = new SimpleStringProperty(grupa);
        this.nota_prog = new SimpleIntegerProperty(nota_prog);
        this.nota_poo = new SimpleIntegerProperty(nota_poo);
        this.nota_ip = new SimpleIntegerProperty(nota_ip);
        this.medie = new SimpleFloatProperty((nota_prog + nota_ip + nota_poo) / 3.0f);
    }

    public FloatProperty medieProperty() {
        return medie;
    }


    public String getNume() {
        return nume.get();
    }

    public StringProperty numeProperty() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume.set(nume);
    }

    public String getPrenume() {
        return prenume.get();
    }

    public StringProperty prenumeProperty() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume.set(prenume);
    }

    public String getGrupa() {
        return grupa.get();
    }

    public StringProperty grupaProperty() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa.set(grupa);
    }

    public int getNota_prog() {
        return nota_prog.get();
    }

    public IntegerProperty nota_progProperty() {
        return nota_prog;
    }

    public void setNota_prog(int nota_prog) {
        this.nota_prog.set(nota_prog);
        meanCompute();
    }

    public int getNota_poo() {
        return nota_poo.get();
    }

    public IntegerProperty nota_pooProperty() {
        return nota_poo;
    }

    public void setNota_poo(int nota_poo) {
        this.nota_poo.set(nota_poo);
        meanCompute();
    }

    public int getNota_ip() {
        return nota_ip.get();
    }

    public IntegerProperty nota_ipProperty() {
        return nota_ip;
    }

    public void setNota_ip(int nota_ip) {
        this.nota_ip.set(nota_ip);
        meanCompute();
    }
}
