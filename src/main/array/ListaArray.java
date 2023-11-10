package array;

import list.EstruturaElementar;

public class ListaArray implements EstruturaElementar{

    private int[] array = new int[1];
    public int indiceAposFim = 1;

    public ListaArray() {
    }

    @Override
    public boolean buscaElemento(int valor) { // Completo, testado.
            for (int i = 0; i < indiceAposFim -1; i++) {
                if (this.array[i] == valor) {
                    return true;
                }
            }
        return false;
    }

    @Override
    public int buscaIndice(int valor) {
        if (valor <= indiceAposFim-1) { // Verifica se o índice é menor ou igual ao tamanho do array.
            return array[valor];
        }
        return 0; // Retorna -1 se o elemento não estiver no array.
    }

    @Override
    public int minimo() { // Completo, testado, corrigido.
        int minimo = array[0];
        if (indiceAposFim != 1) { // Verifica se ao menos um elemento já foi adicionado.
            for (int i = 0; i < indiceAposFim -1; i++) {
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
            for (int i = 0; i < indiceAposFim-1; i++) {
                if (array[i] > maximo) {
                    maximo = array[i];
                }
            }
        }
        return maximo;
    }

    @Override
    public int predecessor(int valor) { // A entrada "valor" é o índice.
        if (indiceAposFim > 2) { // Verifica se ao menos dois elementos foram adicionados.
            return this.array[valor-1];
            }
            return -1;
        }


    @Override
    public int sucessor(int valor) {
        if (indiceAposFim > 2 && valor <= indiceAposFim-2) { // A entrada "valor" é o índice.
            // Verifica se ao menos dois elementos foram adicionados
            // e se a entrada "valor" é menor ou igual ao tamanho do array.
            return this.array[valor+1];
            }
            return -1;
    }

    @Override
    public void insereElemento(int valor) { // Está inserindo no começo.
        int[] arrayCopia = new int[this.array.length+1];
            for (int i = 0; i < indiceAposFim - 1; i++) { 
                arrayCopia[i+1] = this.array[i];
            }
            arrayCopia[0] = valor;
            this.array = arrayCopia;
            indiceAposFim += 1;
        }

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) { 
            int[] arrayCopia = new int[this.array.length+1];
            for (int i = 0; i < buscaIndice; i++) {
                arrayCopia[i] = array[i];
            }
            arrayCopia[buscaIndice] = valor;
            for (int i = buscaIndice + 1; i <= indiceAposFim-1; i++) {
                arrayCopia[i] = this.array[i-1];
            }
            indiceAposFim++;
            this.array = arrayCopia;
        }


    @Override
    public void insereInicio(int valor) { 
        if (indiceAposFim != 1) {
        int[] arrayCopia = new int[this.array.length+1];
        for (int i = 0; i < indiceAposFim-1; i++) {
            arrayCopia[i + 1] = this.array[i];
        }
        arrayCopia[0] = valor;
        indiceAposFim += 1;
        this.array = arrayCopia;
    } else {
        this.array[0] = valor;
        indiceAposFim++;
    }
}

    @Override
    public void insereFim(int valor) { 
        int[] arrayCopia = new int[this.array.length+1];
        for (int i = 0; i < array.length; i++) {
            arrayCopia[i] = this.array[i];
        }
            arrayCopia[indiceAposFim - 1] = valor;
            this.array = arrayCopia;
            indiceAposFim += 1;

    }

    @Override
    public void removeIndice(int indice) {
        if (indice <= (indiceAposFim - 1)) {
            int[] arrayCopia = new int[this.array.length-1];
            for (int i = 0; i < indice; i++) {
                arrayCopia[i] = array[i];
            }
            for (int i = indice+1; i < indiceAposFim-2; i++) {
                arrayCopia[i-1] = this.array[i];
            }
            this.array=arrayCopia;
            indiceAposFim -= 1;
        }
    }

    public void remove(int valor) { 
        // Remove o valor de entrada se e somente se o valor estiver presente no array.
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
    public void removeInicio() { 
            int[] arrayCopia = new int[this.array.length-1];
            for (int i = 1; i < indiceAposFim-1; i++) {
                arrayCopia[i-1] = this.array[i];
            }
            this.array = arrayCopia;
            indiceAposFim -= 1;

    }

    @Override
    public void removeFim() {
        if (indiceAposFim != 1) { // Verifica se ao menos um elemento já foi adicionado.
            int[] arrayCopia = new int[this.array.length-1];
            for (int i = 0; i < indiceAposFim-2; i++) {
                arrayCopia[i] = this.array[i];
            }
            this.array = arrayCopia;
            indiceAposFim -= 1;
        }
    }
}
