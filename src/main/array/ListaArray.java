package array;

import list.EstruturaElementar;

public class ListaArray implements EstruturaElementar{

    private int[] array = new int[1];
    public int indiceAposFim = 1;

    public ListaArray() {
    }

    @Override
    public boolean buscaElemento(int valor) { // Completo, testado.
            for (int i = 0; i < indiceAposFim; i++) {
                if (array[i] == valor) {
                    return true;
                }
            }
        return false;
    }

    @Override
    public int buscaIndice(int valor) {
        if (valor < array.length) { // Verifica se o índice é menor ou igual ao tamanho do array.
            return array[valor];
        }
        return -0; // Retorna -1 se o elemento não estiver no array.
    }

    @Override
    public int minimo() { // Completo, testado, corrigido.
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
    public int maximo() { // Completo, testado, corrigido.
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
    public void insereElemento(int valor) { // Completo, testado, corrigido.
        int[] arrayCopia = new int[this.array.length+1];
            for (int i = 0; i < indiceAposFim - 1; i++) { // Está inserindo no começo.
                arrayCopia[i+1] = this.array[i];
            }
            arrayCopia[0] = valor;
            this.array = arrayCopia;
            indiceAposFim += 1;
        }

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) { // Completo, testado, corrigido.
            int[] arrayCopia = new int[this.array.length+1];
            for (int i = 0; i < buscaIndice; i++) {
                arrayCopia[i] = array[i];
            }
            arrayCopia[buscaIndice] = valor;
            for (int i = buscaIndice + 1; i <= indiceAposFim; i++) {
                arrayCopia[i] = array[i-1];
            }
            indiceAposFim++;
            this.array = arrayCopia;
        }


    @Override
    public void insereInicio(int valor) { // Completo, testado, corrigido.
        if (indiceAposFim != 1) {
        int[] arrayCopia = new int[this.array.length+1];
        for (int i = indiceAposFim - 1; i >= 0; i--) {
            arrayCopia[i + 1] = this.array[i];
        }
        arrayCopia[0] = valor;
        indiceAposFim += 1;
        this.array = arrayCopia;
    } else {
        this.array[0] = valor;
    }
}

    @Override
    public void insereFim(int valor) { // Completo, testado, corrigido.
        int[] arrayCopia = new int[this.array.length+1];
        for (int i = 0; i < array.length; i++) {
            arrayCopia[i] = this.array[i];
        }
            arrayCopia[indiceAposFim - 1] = valor;
            this.array = arrayCopia;
            indiceAposFim += 1;

    }

    @Override
    public void removeIndice(int indice) { // Completo, testado.
        if (indice <= (indiceAposFim - 1)) {
            int[] arrayCopia = new int[this.array.length+1];
            for (int i = indice; i < indiceAposFim - 1; i++) {
                array[i] = array[i + 1];
            }
            indiceAposFim -= 1;
            array[indiceAposFim] = 0;
        }
    }

    public void remove(int valor) { //Completo, testado, corrigido.
        if (buscaElemento(valor)) { // Verifica se o valor existe no array.
            int[] arrayCopia = new int[this.array.length-1];
            int indiceElemRemovido = 0;
            for (int i = 0; i < indiceAposFim; i++){
                if (array[i] == valor) {
                    indiceElemRemovido = i; //Salva o índice para continuar o processo.
                    break;
                } else {
                    arrayCopia[i] = this.array[i];
                }
            }
            for (int i = indiceElemRemovido+1; i < indiceAposFim; i++) {
                arrayCopia[i-1] = this.array[i];
            }
            this.array = arrayCopia;
            indiceAposFim--;
    }
}

    @Override
    public void removeInicio() { // Completo, testado, corrigido.
        if (indiceAposFim != 1) {
            int[] arrayCopia = new int[this.array.length-1];
            for (int i = 1; i < indiceAposFim; i++) {
                arrayCopia[i-1] = this.array[i];
            }
            this.array = arrayCopia;
            indiceAposFim -= 1;

        }
    }

    @Override
    public void removeFim() { // Completo, testado.
        if (indiceAposFim != 1) { // Verifica se ao menos um elemento já foi adicionado.
            int[] arrayCopia = new int[this.array.length-1];
            for (int i = 1; i < indiceAposFim-1; i++) {
                arrayCopia[i] = this.array[i];
            }
            this.array = arrayCopia;
            indiceAposFim -= 1;
        }
    }
}
