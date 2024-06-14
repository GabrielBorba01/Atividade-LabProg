import java.util.Scanner;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    Scanner leitor = new Scanner(System.in);

    // Construtor padrão
    public Data(){}

    //setData com validacao de dia, mes e ano.
    public void setData(int dia, int mes, int ano){
        if (ano < 1){
            System.out.println("Ano Invalido!");
            return;
        }
        if (mes < 1 || mes > 12){
            System.out.println("Mes Invalido!");
        }

    }

    //verificar os dias dos meses
    private int diasNoMes(int mes, int ano){
        int[] dias = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (mes == 2 && (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0))) {
            return 29;
        }
        return dias[mes-1];
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getData(){
        String a = String.format("%02d/%02d/%04d", this.dia, this.mes, this.ano);
        return a;
    }
}
