enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel:Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome.")
    }
}

fun main() {
    // Criação de conteúdo educacional
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 90, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 120, Nivel.INTERMEDIARIO)

    
    // Criação de uma formação com uma lista de conteúdos
    val formacaoKotlin = Formacao("Formação Kotlin", listOf(conteudo1, conteudo2))
    
    // Criação de usuários
    val usuario1 = Usuario("Alice")
    val usuario2 = Usuario("Bob")
    
    // Matrícula dos usuários na formação
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    
    // Exibindo lista de inscritos
    println("Inscritos na formação ${formacaoKotlin.nome}: ${formacaoKotlin.inscritos.map { it.nome }}")
}
