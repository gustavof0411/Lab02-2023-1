package array;

import list.EstruturaElementar;

public class ListaArray implements EstruturaElementar{

    private int[] array;
    public int indiceAposFim = 1;

    public ListaArray() {
        this.array = new int[100];
    }

    @Override
    public boolean buscaElemento(int valor) { // Completo, testado.
        if (indiceAposFim != 1) {
            for (int i = 0; i < indiceAposFim; i++) {
                if (array[i] == valor) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int buscaIndice(int valor) {
        if (valor < array.length) { // Verifica se o índice é menor ou igual ao tamanho do array.
            return array[valor];
        }
        return -1; // Verificar retorno (pode enganar).
    }

    @Override
    public int minimo() { // Completo, testado.
        int minimo = array[0];
        if (indiceAposFim != 1) { // Verifica se ao menos um elemento já foi adicionado.
            for (int i = 0; i < indiceAposFim; i++) {
                if (array[i] < minimo) {
                    minimo = array[i];
                }
            }
        }
        return minimo;
    }

    @Override
    public int maximo() { // Completo, testado.
        int maximo = array[0];
        if (indiceAposFim > 1) { // Verifica se ao menos um elemento já foi adicionado.
            for (int i = 0; i < indiceAposFim; i++) {
                if (array[i] > maximo) {
                    maximo = array[i];
                }
            }
        }
        return maximo;
    }

    @Override
    public int predecessor(int valor) {
        if (indiceAposFim > 2) {
            int indice = buscaIndice(valor);
            if (indice < array.length - 1) {

            }

        }
        return 0;
    }

    @Override
    public int sucessor(int valor) {
        return 0;
    }

    @Override
    public void insereElemento(int valor) { // Completo, testado.
        if (indiceAposFim < array.length) {
            for (int i = indiceAposFim - 1; i >= 0; i--) { // Está inserindo no começo.
                array[i + 1] = array[i];
            }
            array[0] = valor;
            indiceAposFim += 1;
        }
    }

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) { // Completo.
        if ((buscaIndice < indiceAposFim) && (indiceAposFim < array.length)) {
            for (int i = indiceAposFim - 1; i <= buscaIndice; i--) {
                array[i + 1] = array[i];
            }
            array[buscaIndice] = valor;
            indiceAposFim = buscaIndice + 1;
        } else if (buscaIndice >= indiceAposFim && buscaIndice < array.length) {
            array[buscaIndice] = valor;
            indiceAposFim = buscaIndice + 1;

        }
    }

    @Override
    public void insereInicio(int valor) { // Completo, testado.
        for (int i = indiceAposFim - 1; i >= 0; i--) {
            array[i + 1] = array[i];
        }
        array[0] = valor;
        indiceAposFim += 1;
    }

    @Override
    public void insereFim(int valor) { // Completo.
        if (indiceAposFim < array.length) {
            array[indiceAposFim] = valor;
            indiceAposFim += 1;
        }
    }

    @Override
    public void removeIndice(int indice) { // Completo, testado.
        if (indice <= (indiceAposFim - 1)) {
            for (int i = indice; i < indiceAposFim - 1; i++) {
                array[i] = array[i + 1];
            }
            indiceAposFim -= 1;
            array[indiceAposFim] = 0;
        }
    }

    public void remove(int valor) {

    }

    @Override
    public void removeInicio() { // Completo, testado.
        if (indiceAposFim != 1) {
            for (int i = 0; i < indiceAposFim; i++) {
                array[i] = array[i + 1];
            }
            array[indiceAposFim + 1] = 0;
            indiceAposFim -= 1;
        }
    }

    @Override
    public void removeFim() { // Completo, testado.
        if (indiceAposFim != 1) {
            indiceAposFim -= 1;
            array[indiceAposFim] = 0;
        }
    }
}
