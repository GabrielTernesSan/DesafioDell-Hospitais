public class DadosPaciente {
	private String dataSolicitacao;
	private String sexo;
	private int idade;
	private String muniResidencial;
	private String solicitante;
	private String muniSolicitante;
	private String dataAutorizacao;
	private String dataInternacao;
	private String dataAlta;
	private String executante;
	private int hrsFila;

	public DadosPaciente(String dataSolicitacao, String sexo, int idade, String muniResidencial, String solicitante,
			String muniSolicitante, String dataAutorizacao, String dataInternacao, String dataAlta, String executante,
			int hrsFila) {
		this.dataSolicitacao = dataSolicitacao;
		this.sexo = sexo;
		this.idade = idade;
		this.muniResidencial = muniResidencial;
		this.solicitante = solicitante;
		this.muniSolicitante = muniSolicitante;
		this.dataAutorizacao = dataAutorizacao;
		this.dataInternacao = dataInternacao;
		this.dataAlta = dataAlta;
		this.executante = executante;
		this.hrsFila = hrsFila;
	}

	public String getDataSolicitacao() {
		return dataSolicitacao;
	}

	public String getSexo() {
		return sexo;
	}

	public int getIdade() {
		return idade;
	}

	public String getMuniResidencial() {
		return muniResidencial;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public String getMuniSolicitante() {
		return muniSolicitante;
	}

	public String getDataAutorizacao() {
		return dataAutorizacao;
	}

	public String getDataInternacao() {
		return dataInternacao;
	}

	public String getDataAlta() {
		return dataAlta;
	}

	public String getExecutante() {
		return executante;
	}

	public int getHrsFila() {
		return hrsFila;
	}
	/*
	 * idade, o município residencial e solicitante de cada um deles, as datas de autorização, de internação e alta e o executante;
	 * */
	
	@Override
	public String toString() {
		return "[ " + "Muni. Residencial: " + getMuniResidencial() + " "
		+ "Idade: " + getIdade() + " "
		+ "Sexo: " + getSexo() + " "
		+ "Data de Internação: " + getDataInternacao().substring(0, 10) + " "
		+ "Data de alta: " + getDataAlta().substring(0, 10) + " "
		+ "Horas na fila: " + getHrsFila() + " "
		+ " ]";
	}

}
