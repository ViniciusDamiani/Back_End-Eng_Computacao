package Avaliativos.Lista04;

class FaturaTeste {
    public static void main(String[] args) {
        // Criando objetos Fatura
        Fatura f1 = new Fatura("001", "Mouse sem fio", 3, 80.0);
        Fatura f2 = new Fatura("002", "Teclado mecânico", -2, -150.0); // valores inválidos (tratados)

        // Exibindo informações
        System.out.println(f1);
        System.out.println(f2);

        // Exibindo só os totais (opcional)
        System.out.println("Total Fatura 1: R$ " + f1.getTotalFatura());
        System.out.println("Total Fatura 2: R$ " + f2.getTotalFatura());
    }
}
 