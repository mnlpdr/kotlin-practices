//Respostas
//Questão 1

class Produto (nome: String, preco: Double) {
    var nome: String = nome
    var preco: Double = preco
}

class Cliente (private var nome: String = "", private var idade: Int = 0){

    public fun mostrarIdade() {
        println("A idade é $idade")
    }

}

abstract class Personagem {
    abstract fun atacar()
}

class Guerreiro : Personagem () {
    override fun atacar(){
        println("Guerreiro ataca com a espada!")
    }
}

class Mago : Personagem (){
    override fun atacar() {
        println("Mago ataca com magia!")
    }
}

interface FormaGeometrica{
    abstract fun calcularArea(): Double
}

class Retangulo(val altura: Double, val largura: Double) : FormaGeometrica{
    override fun calcularArea(): Double {
        val area = altura * largura
        println(area)
        return area
    }
}

class Circulo(val raio: Double): FormaGeometrica{
    override fun calcularArea(): Double {
      val area = 3.14 * (raio*raio)
        println(area)
        return area
    }

}

class ContaBancaria{
    var numeroConta: String = ""
    var nomeTitular: String = ""
        set (value){
            field = value.replaceFirstChar {if (it.isLowerCase()) it.titlecase() else it.toString() }
        }
    private var saldo: Double = 0.0
        private set(value){
            if (value >=0.0){
                field = value
            } else {
                println("Não é possível definir um saldo negativo")
            }
        }

    public fun getTitular(): String {
        return this.nomeTitular
    }


}


fun main() {

    val produto1 = Produto("Café", 5.0)

    println(produto1)

    val cliente1 = Cliente("Fulano", 30)
    cliente1.mostrarIdade()

    val guerreiro1 = Guerreiro()
    guerreiro1.atacar()

    val mago1 = Mago()
    mago1.atacar()

    val retangulo1 = Retangulo(2.0, 4.0)
    retangulo1.calcularArea()

    val circulo1 = Circulo(4.0)
    circulo1.calcularArea()

}



/*
// Questão 1
class Produto {
    var nome: String
    var preco: Double

    // Implemente os construtores conforme especificado na questão
}

fun main() {
    // Crie instâncias das diferentes classes Produto utilizando os seus construtores e imprima os detalhes de cada produto.
}

// Questão 2
class Cliente {
    var nome: String = ""
    private var idade: Int = 0

    // Utilize os modificadores de visibilidade para definir os atributos nome e idade conforme especificado na questão

    // Crie um método público na classe Cliente chamado mostrarIdade() conforme especificado na questão
}

fun main() {
    // Crie uma instância de Cliente e chame o método mostrarIdade() para verificar seu funcionamento.
}

// Questão 3
abstract class Personagem {
    // Crie um método abstrato atacar() conforme especificado na questão
}

class Guerreiro : Personagem() {
    override fun atacar() {
        // Implemente o método atacar() de acordo com as características do Guerreiro
    }
}

class Mago : Personagem() {
    override fun atacar() {
        // Implemente o método atacar() de acordo com as características do Mago
    }
}

fun main() {
    // Crie instâncias de Guerreiro e Mago e chame o método atacar() de cada um para verificar se estão realizando os ataques corretamente de acordo com suas respectivas classes.
}

// Questão 4
interface FormaGeometrica {
    // Declare um método abstrato calcularArea() conforme especificado na questão
}

class Retangulo(val altura: Double, val largura: Double) : FormaGeometrica {
    override fun calcularArea(): Double {
        // Implemente o método calcularArea() para o Retangulo conforme especificado na questão
    }
}

class Circulo(val raio: Double) : FormaGeometrica {
    override fun calcularArea(): Double {
        // Implemente o método calcularArea() para o Circulo conforme especificado na questão
    }
}

fun main() {
    // Crie instâncias dessas duas classes e chame o método calcularArea() em cada uma delas para verificar o resultado.
}

// Questão 5
class ContaBancaria {
    var numeroConta: String = ""
    var nomeTitular: String = ""
    private var saldo: Double = 0.0

    // Implemente um getter personalizado para a propriedade nomeTitular conforme especificado na questão

    // Implemente override do setter para o atributo saldo conforme especificado na questão
}

fun main() {
    // Crie uma instância de ContaBancaria. Altere o nome do titular para uma string que inicie com letra minúscula e mude o saldo para um valor negativo. Imprima os valores para verificar se as regras dos getters e setters estão sendo aplicadas corretamente.
}
 */