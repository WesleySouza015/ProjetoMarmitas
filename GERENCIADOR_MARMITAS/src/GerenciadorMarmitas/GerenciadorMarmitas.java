package GerenciadorMarmitas;
import java.util.Scanner;

public class GerenciadorMarmitas {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	

    	// LISTA DE INGREDIENTES
    	String[] ingredientes = {"ARROZ", "FEIJÃO", "FRANGO", "CARNE BOVINA", "COSTELINHA SUÍNA"};
    	float[] precos = new float[ingredientes.length];
    	float[] quantidade = new float[ingredientes.length];

    	// CADASTRO DOS INGREDIENTES
    	for (int i = 0; i < ingredientes.length; i++) {
    		System.out.print("DIGITE O VALOR TOTAL PAGO PELO " + ingredientes[i] + " (R$): ");
    		precos[i] = sc.nextFloat();
    		System.out.print("DIGITE A QUANTIDADE DE " + ingredientes[i] + " (EM KG): ");
    		quantidade[i] = sc.nextFloat() * 1000; // CONVERTE PARA GRAMAS
    	}

    	// CÁLCULO DO CUSTO POR INGREDIENTE POR MARMITA (EM GRAMAS)
    	float precoArroz = precos[0] / quantidade[0] * 150;
    	float precoFeijao = precos[1] / quantidade[1] * 100;
    	float precoFrango = precos[2] / quantidade[2] * 100;
    	float precoCarneBovina = precos[3] / quantidade[3] * 100;
    	float precoCostelinha = precos[4] / quantidade[4] * 100;

    	// CÁLCULO DO CUSTO DAS MARMITAS
    	float custoMarmitaFrango = precoArroz + precoFeijao + precoFrango;
    	float custoMarmitaBovina = precoArroz + precoFeijao + precoCarneBovina;
    	float custoMarmitaSuina = precoArroz + precoFeijao + precoCostelinha;

    	// INICIALIZA VARIÁVEIS DE CONTROLE DE PRODUÇÃO
    	int marmitasFrango = 0, marmitasBovina = 0, marmitasSuina = 0;

    	// LOOP PARA CALCULAR A QUANTIDADE PRODUZÍVEL DE CADA MARMITA
    	while (quantidade[0] >= 150 && quantidade[1] >= 100 && (quantidade[2] >= 100 || quantidade[3] >= 100 || quantidade[4] >= 100)) {
    		if (custoMarmitaFrango <= 9 && quantidade[2] >= 100) {
    			marmitasFrango++;
    			quantidade[0] -= 150;
    			quantidade[1] -= 100;
    			quantidade[2] -= 100;
    		} 
    		
    	else if (custoMarmitaBovina <= 9 && quantidade[3] >= 100) {
    		marmitasBovina++;
        	quantidade[0] -= 150;
        	quantidade[1] -= 100;
        	quantidade[3] -= 100;
    		} 
    		
    	else if (custoMarmitaSuina <= 9 && quantidade[4] >= 100) {
    		marmitasSuina++;
        	quantidade[0] -= 150;
        	quantidade[1] -= 100;
        	quantidade[4] -= 100;
    	} 
    	
    	else {
        break;
    	}
    		
    	}

    	System.out.println("-----------------------------------------------------------------------------------------------------------------");
    	// EXIBE OS RESULTADOS DE PRODUÇÃO
    	if (marmitasFrango > 0) {
    		System.out.println("MARMITA FRANGO: QUANTIDADE PRODUZIDA = " + marmitasFrango + " | CUSTO = R$ " + String.format("%.2f", custoMarmitaFrango));
    	} 
    	else {
    		System.out.println("MARMITA FRANFO NÃO FOI PRODUZIDA POIS O CUSTO ESTÁ ACIMA DO LIMITE DE R$ 9,00 OU NÃO HÁ INGREDIENTES SUFICIENTES.");
    	}

    	if (marmitasBovina > 0) {
    		System.out.println("MARMITA BOVINA: QUANTIDADE PRODUZIDA = " + marmitasBovina + " | CUSTO = R$ " + String.format("%.2f", custoMarmitaBovina));
    	} 
    	else {
    		System.out.println("MARMITA  BOVINA NÃO FOI PRODUZIDA POIS O CUSTO ESTÁ ACIMA DO LIMITE DE R$ 9,00 OU NÃO HÁ INGREDIENTES SUFICIENTES.");
    	}

    	if (marmitasSuina > 0) {
    		System.out.println("MARMITA SUINA: QUANTIDADE PRODUZIDA = " + marmitasSuina + " | CUSTO = R$ " + String.format("%.2f", custoMarmitaSuina));
    	} 
    	else {
 	  System.out.println("MARMITA  SUINA NÃO FOI PRODUZIDA POIS O CUSTO ESTÁ ACIMA DO LIMITE DE R$ 9,00 OU NÃO HÁ INGREDIENTES SUFICIENTES.");
    	}
    	System.out.println("-----------------------------------------------------------------------------------------------------------------");

    	// EXIBE O CUSTO DE CADA MARMITA
    	System.out.printf("CUSTO DA MARMITA FRANGO: R$ %.2f%n", custoMarmitaFrango);
    	System.out.printf("CUSTO DA MARMITA BOVINA: R$ %.2f%n", custoMarmitaBovina);
    	System.out.printf("CUSTO DA MARMITA SUINA: R$ %.2f%n", custoMarmitaSuina);


    	sc.close();

    	}
	}