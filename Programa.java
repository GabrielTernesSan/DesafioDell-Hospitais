import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;


public class Programa {
	public static void main(String[] args) throws ParseException, IOException {

		int br = 0;

		Scanner sc = new Scanner(System.in);

		List<DadosPaciente> pacientes = ReadDocument();

		while (br != 1) {
			System.out.println("===============MENU===============");
			System.out.println("1 - Consultar média de idade dos pacientes");
			System.out.println("2 - Consultar internações por ano");
			System.out.println("3 - Consultar hospitais");
			System.out.println("4 - Calcular tempo de internação");
			System.out.println("5 - Determinar tempos de espera na fila");
			System.out.println("6 - Encerrar programa");
			System.out.println();
			System.out.println("Opção:");
			int option = sc.nextInt();

			if (option == 1) {
				/*
				 * Permitir que o usuário informe o nome do município residencial e como resultado o programa deverá exibir: 
				 * a. O número total de pacientes do município; 
				 * b. A média de idade dos pacientes separados por gênero; 
				 * c. A média de idade de todos os pacientes;
				 */
				sc.nextLine();
				System.out.println("Municipio Residencial: ");
				String municipio = sc.nextLine();
				int count = 0;
				int masc = 0;
				int fem = 0;

				int somaGeral = 0;
				int somaMasc = 0;
				int somaFemi = 0;

				for (int i = 0; i < pacientes.size(); i++) {
					if (pacientes.get(i).getMuniResidencial().contains(municipio.toUpperCase())) {
						count++;
						if (pacientes.get(i).getSexo().contains("MASCULINO")) {
							masc++;
							somaMasc += pacientes.get(i).getIdade();
						} else if (pacientes.get(i).getSexo().contains("FEMININO")){
							somaFemi += pacientes.get(i).getIdade();
							fem++;
						}
						somaGeral += pacientes.get(i).getIdade();
					}
				}
				System.out.println("Total de paciente no municipio: " + count);
				System.out.println("Média de idade de pacientes do sexo Masculino: " + (somaMasc / masc));
				System.out.println("Média de idade de pacientes do sexo Feminino: " + (somaFemi / fem));
				System.out.println("Média de idade de pacientes: " + (somaGeral / count));

			} else if (option == 2) {
				/*
				 * Permitir que o usuário informe o nome do município residencial e como
				 * resultado o programa deverá exibir uma lista com os anos de 2018 a 2021 e a
				 * quantidade de pacientes que foram internados por ano;
				 */
				sc.nextLine();
				System.out.println("Municipio Residencial: ");
				String municipio = sc.nextLine();
				int count2018 = 0;
				int count2019 = 0;
				int count2020 = 0;
				int count2021 = 0;
				
				for (int i = 0; i < pacientes.size(); i++) {
					if(pacientes.get(i).getMuniResidencial().contains(municipio.toUpperCase())) {
						if(pacientes.get(i).getDataInternacao().contains("2018")) {
							count2018++;
							System.out.println(pacientes.get(i));
						} else if(pacientes.get(i).getDataInternacao().contains("2019")) {
							count2019++;
							System.out.println(pacientes.get(i));
						} else if(pacientes.get(i).getDataInternacao().contains("2020")) {
							count2020++;
							System.out.println(pacientes.get(i));
						} else if(pacientes.get(i).getDataInternacao().contains("2021")) {
							count2021++;
							System.out.println(pacientes.get(i));
						}
					}
				}
				System.out.println("Pacientes internados em 2018: " + count2018);
				System.out.println("Pacientes internados em 2019: " + count2019);
				System.out.println("Pacientes internados em 2020: " + count2020);
				System.out.println("Pacientes internados em 2021: " + count2021);
				
			} else if (option == 3) {
				/*
				 * Permitir que o usuário digite o nome do executante e como resultado o
				 * programa deverá exibir todos os pacientes que foram internados, sua idade, o
				 * município residencial e solicitante de cada um deles, as datas de
				 * autorização, de internação e alta e o executante;
				 */
				sc.nextLine();
				System.out.println("Nome do executante: ");
				String executante = sc.nextLine();
				
				for(int i = 0; i < pacientes.size(); i++) {
					if(pacientes.get(i).getExecutante().contains(executante.toUpperCase())) {
						System.out.println("[ Idade: " + pacientes.get(i).getIdade() + " "
											+ "Municipio Residencial: " + pacientes.get(i).getMuniResidencial()  + " "
											+ "Solicitante: " + pacientes.get(i).getSolicitante() + " "
											+ "Data de autorização: " + pacientes.get(i).getDataAutorizacao() + " "
											+ "Data de internação: " + pacientes.get(i).getDataInternacao() + " "
											+ "Data de alta: " + pacientes.get(i).getDataAlta() + " "
											+ "Executante: " + pacientes.get(i).getExecutante() + " ]");
					}
				}
			} else if (option == 4) {
				/*
				 * Permitir que o usuário digite o nome do solicitante e como resultado o programa deverá exibir: 
				 * a. Uma lista com todos os pacientes; 
				 * b. O nome dos hospitais executantes; 
				 * c. O número de dias que os pacientes permaneceram internados desde a solicitação até a alta deste paciente;
				 */
				sc.nextLine();
				System.out.println("Nome do solicitante: ");
				String solicitante = sc.nextLine();
				
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				
				for(int i = 0; i < pacientes.size(); i++) {
					if(pacientes.get(i).getSolicitante().contains(solicitante.toUpperCase())) {
						System.out.println(pacientes.get(i));
						System.out.println("Hospital executante: " + pacientes.get(i).getExecutante());
						
					    						
						Date dateInterna = formatter.parse(pacientes.get(i).getDataInternacao());
						Date dateAlta = formatter.parse(pacientes.get(i).getDataAlta());
						
						Calendar cal1 = new GregorianCalendar();
						cal1.setTime(dateInterna);
						Calendar cal2 = new GregorianCalendar();
						cal2.setTime(dateAlta);

						long dias = ((cal2.getTimeInMillis() - cal1.getTimeInMillis()) / (24*60*60*1000));

						System.out.println("Dias internado = " + dias + " dias");
						
					}
				}
				
			} else if (option == 5) {
				// O programa deverá determinar e exibir os cinco casos com maior tempo de espera na fila;
				List<Integer> testList = new ArrayList<>();
				List<DadosPaciente> maiores = new ArrayList<>();
				
				for(int i = 0; i < pacientes.size(); i++) {
					testList.add(pacientes.get(i).getHrsFila());
					testList.sort(Comparator.reverseOrder());
				}
				
				for(int i = 0; i < pacientes.size(); i++) {
					for(int j = 0; j < 5; j++) {
						if(pacientes.get(i).getHrsFila() == testList.get(j)) {
							maiores.add(pacientes.get(i));
						}
					}
				}
				System.out.println("1º " + maiores.get(4));
				System.out.println("2º " + maiores.get(3));
				System.out.println("3º " + maiores.get(0));
				System.out.println("4º " + maiores.get(1));
				System.out.println("5º " + maiores.get(2));
			} else if (option == 6) { // Permitir que o usuário saia do programa.
				br = 1;
				System.out.println("Programa encerrado!");
			} else {
				System.out.println("Opção inválida!");
			}
		}
		sc.close();
	}

	public static List<DadosPaciente> ReadDocument() throws IOException, ParseException {
		BufferedReader bfr = null;
		String linha = "";
		String csvDivisor = ";";

		List<DadosPaciente> pacientes = new ArrayList<>();
		try {

			bfr = new BufferedReader(new FileReader("C:\\Users\\Gabri\\Desktop\\Desafios DELL\\Hospitais\\dados.csv"));
			bfr.readLine();

			while ((linha = bfr.readLine()) != null) {
				String[] data = linha.split(csvDivisor);

				DadosPaciente paciente = new DadosPaciente(data[4].substring(0, 10), data[5], Integer.parseInt(data[6].replace(".0", "")), data[7],
						data[8], data[9], data[14].substring(0, 10), data[15].substring(0, 10), data[16].substring(0, 10), data[17], Integer.parseInt(data[18]));
				pacientes.add(paciente);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pacientes;
	}
}
