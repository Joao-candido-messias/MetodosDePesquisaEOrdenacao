import time

from model.model import ListaModel

from view.view import TerminalView

class MedicaoTempoController:
    """Responsável por unir o Model e a View, além de medir o tempo."""

    def __init__(self):
        self.model = ListaModel()
        self.view = TerminalView()

    def executar(self) -> None:
        """Executa o fluxo principal do programa imitando o 'main' do Java."""
        
        #Inicializa contagem de tempo
        tempo_inicio = time.perf_counter_ns()

        self.model.popular_lista_aleatoria(quantidade=100000, inicio=100, fim=100000)

        #Finaliza contagem de tempo
        tempo_fim = time.perf_counter_ns()
        
        # Calcula a diferença e converte de nanosegundos para milisegundos
        tempo_ms_1 = (tempo_fim - tempo_inicio) / 1_000_000
        self.view.exibir_tempo_rotina(1, tempo_ms_1)
        
        # Rotina 2: Números Sequenciais
        tempo_inicio = time.perf_counter_ns()
        self.model.popular_lista_sequencial(quantidade=100000, inicio=1)
        tempo_fim = time.perf_counter_ns()
        
        tempo_ms_2 = (tempo_fim - tempo_inicio) / 1_000_000
        self.view.exibir_tempo_rotina(2, tempo_ms_2)