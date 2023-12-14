data class ConteudoEducacional(var nome: String, val duracao: Int = 60) 

    class Usuario(val nome: String)
    
    class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>){
    
        val inscritos = mutableListOf<Usuario>()
    
    	fun matricular(usuario: Usuario) {
           try{
               if(inscritos.contains(usuario)){
                   throw Exception("Usuario já matriculado nesta formação ${nome}")
               }
       	 inscritos.add(usuario)
         println("Usuário ${usuario.nome} matriculado na ${nome}")
           } catch (e: Exception){
             println("Erro ao matricular usuário: ${e.message}")
         }
    }
}

fun main() {
    val algoritmo = ConteudoEducacional("Curso de algoritmo", 15)
    val kotlin = ConteudoEducacional("Curso de Kotlin", 45)
    
    val formacaoKotlin = Formacao("Formação Kotlin", listOf(algoritmo, kotlin))

    val Joao = Usuario("Joao")
    val Maria = Usuario("Maria")

    formacaoKotlin.matricular(Joao)
    formacaoKotlin.matricular(Maria)
   
    println("Os alunos inscritos nos cursos disponíveis, ${algoritmo.nome} e ${kotlin.nome} são ${Joao.nome} e ${Maria.nome}")
}


