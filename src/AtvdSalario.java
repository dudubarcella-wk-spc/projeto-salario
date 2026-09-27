//1. Empresa X: salário base = R$ 5000
//2. Férias: 1/3 de 5000 = R$ 1250 + R$ 5000
//3. desconto de adiantamento = -5% (a cada 5 dias) com base no salário base (R$ 5000)
//4. a cada uma hora extra vale o dobro da hora normal


import javax.swing.JOptionPane;
public class AtvdSalario {
    public static void main(String[] args) {
        //String funcionarios;
        int op;
        String funcionarios;
        int continuar;

        funcionarios = JOptionPane.showInputDialog("***** Nome do funcionário *****");

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(
                    "Escolha sua opção: \n" +
                            "1 - Aumento \n" +
                            "2 - Férias \n" +
                            "3 - Adiantamento \n" +
                            "4 - Horas extras \n"));
            switch (op) {
                case 1:
                    modMult();
                    break;
                case 2:
                    modFerias();
                    break;
                case 3:
                    modDesc();
                    break;
                case 4:
                    modExtra();
                    break;

            }

            continuar = JOptionPane.showConfirmDialog(null,
                    "Deseja realizar outra operação?",
                    "Continuar", JOptionPane.YES_NO_OPTION);
        } while (continuar == JOptionPane.YES_OPTION);
    }
    static void modMult(){
        int tempo;
        double v1, v2;
        v1 = 5000;
        tempo = Integer.parseInt(JOptionPane.showInputDialog("Quanto tempo de empresa: "));
        if (tempo <= 1 ) {
            v2 = v1 * 0.05;
            v1 = v1 + v2;
            JOptionPane.showMessageDialog(null,"Seu salário é: " + v1 );
        } else if (tempo <= 3) {
            v2 = v1 * 0.10;
            v1 = v1 + v2;
            JOptionPane.showMessageDialog(null,"Seu salário é: " + v1 );
        } else if ( tempo <= 6) {
            v2 = v1 * 0.25;
            v1 = v1 + v2;
            JOptionPane.showMessageDialog(null,"Seu salário é: " + v1 );
        } else if (tempo > 9) {
            v2 = v1 * 0.45;
            v1 = v1 + v2;
            JOptionPane.showMessageDialog(null,"Seu salário é: " + v1 );
        } else {
            JOptionPane.showMessageDialog(null,"É necessário mais de 1 ano de empresa para um aumento, então seu salário é R$" + v1 );
        }

    }
    static void modFerias(){
        int hs;
        double tempo = 0;

        hs = Integer.parseInt(JOptionPane.showInputDialog("Quantas horas foram trabalhadas? "));
        tempo = Integer.parseInt(JOptionPane.showInputDialog("Quanto tempo de empresa: "));
        if (hs >= 2640 && tempo <= 1){
            JOptionPane.showMessageDialog(null, "Férias concedida, você bateu a meta de horas. Aproveite seus 30 dias. Valor a receber R$: " + 6500);
        } else if (hs >= 2640 && tempo <= 3) {
            JOptionPane.showMessageDialog(null, "Férias concedida, você bateu a meta de horas. Aproveite seus 30 dias. Valor a receber R$: " + 6750);
        } else if (hs >= 2640 && tempo <= 6) {
            JOptionPane.showMessageDialog(null, "Férias concedida, você bateu a meta de horas. Aproveite seus 30 dias. Valor a receber R$: " + 7500);
        } else if (hs >= 2640 && tempo <= 9) {
            JOptionPane.showMessageDialog(null, "Férias concedida, você bateu a meta de horas. Aproveite seus 30 dias. Valor a receber R$: " + 8500);
        } else {
            JOptionPane.showMessageDialog(null, "Férias recusada pelas normas da empresa");
        }

    }
    static void modDesc(){
        //25 dias trabalhados (tendo 1 sábado letivo) a cada 5 dias = desconto de 5%
        double desc, adian, v1;

        adian = Integer.parseInt(JOptionPane.showInputDialog("Quasntos dias antes do pagamento você gostaria de receber? "));

        desc = 0.05;
        v1 = 5000;
        adian = v1 * (desc * adian);

        if (adian == 5){
            JOptionPane.showMessageDialog(null, "Você irá ser descontado 5% do total de seu salário:  " + adian);
        } else if (adian <= 10) {
            JOptionPane.showMessageDialog(null, "Você irá ser descontado 10% do total de seu salário: " + adian);
        } else if (adian <= 15) {
            JOptionPane.showMessageDialog(null, "Você irá ser descontado 15% do total de seu salário: " + adian);
        } else if (adian <= 20) {
            JOptionPane.showMessageDialog(null, "Você irá ser descontado 20% do total de seu salário: " + adian);
        } else {
            JOptionPane.showMessageDialog(null, "Você irá ser descontado 25% do total de seu salário: " + adian);
        }
    }
    static void modExtra(){
        //hora normal = 22,72
        //hora dobro =  45,44
        //hora extra = hora dobro + qntd de hs trabalhado

        double hn, hd, he;
        int qntd;
        qntd = 0;
        qntd = Integer.parseInt(JOptionPane.showInputDialog("Quantas horas extras foram trabalhadas? "));

        hn = 22.72;
        hd = 45.44;
        he = hd * qntd;

        JOptionPane.showMessageDialog(null, "Você trabalhou " + qntd + " horas extras, portanto irá receber um acréscimo por hora de: " + he);
    }
}