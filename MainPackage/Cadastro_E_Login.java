package MainPackage;

import java.time.LocalDate;
import java.util.List;

public class Cadastro_E_Login {

    public static void CadastrarUser() {

        System.out.println("\nDigite seu Nome: ");
        String Nome = lerDados.lerTexto("\nPreencha o Campo de Nome!\n");

        System.out.println("\nDigite seu Sobrenome:");
        String Sobrenome = lerDados.lerTexto("\nPreencha o Campo de Sobrenome!\n");

        System.out.println("\nDigite sua Data de Nascimento:");
        LocalDate Data_Nasc = lerDados.lerDataUser("\nPreencha o Campo de Data de Nascimento! \n");

        String CPF_OU_CNPJ = VerificarCPF_OU_CNPJExiste();

        String Telefone = VerificarTelefoneExiste();

        String Email = VerificarEmailExiste();

        System.out.println("\nDigite sua Senha: ");
        String Senha = lerDados.lerTexto("\nPreencha o Campo de Senha!\n");

        var Usuario = new ObjectUser(Nome, Sobrenome, Data_Nasc, CPF_OU_CNPJ, Telefone, Email, Senha);
        Txt_User.salvar(Usuario);

        System.out.println("\n ---------- Usuário cadastrado! ----------");

    }


    public static String VerificarCPF_OU_CNPJExiste(){

        var users = Txt_User.lerTudo();

        String CPF_OU_CNPJ;

        System.out.println("\nDigite seu CPF ou CNPJ: ");
        CPF_OU_CNPJ = lerDados.lerTexto("\nPreencha o Campo de CPF OU CNPJ!\n");

        CPF_OU_CNPJ = RegexFunctions.formatarCPF(CPF_OU_CNPJ);

        String CPF_OU_CNPJInput;

        while (ObjectUser.BuscarUser_CPFOUCNPJ(users ,CPF_OU_CNPJ).isPresent()) {

            System.out.println("\nO CPF OU CNPJ digitado já existe! Digite outro CPF ou CNPJ: ");
            CPF_OU_CNPJInput = lerDados.lerTexto("\nPreencha o Campo de CPF OU CNPJ!\n");

            CPF_OU_CNPJ = RegexFunctions.formatarCPF(CPF_OU_CNPJInput);
        }

        return CPF_OU_CNPJ;

    }


    public static String VerificarTelefoneExiste(){

        var users = Txt_User.lerTudo();

        String Telefone;

        System.out.println("\nDigite seu número de telefone sem espaços, parênteses ou traços: ");
        Telefone = lerDados.lerTexto("\nPreencha o Campo de Telefone!\n");

        Telefone = RegexFunctions.formatarTelefone(Telefone);

        String telefoneInput;

        while (ObjectUser.BuscarUser_Telefone(users ,Telefone).isPresent()) {

            System.out.println("\nO telefone digitado já existe! Digite outro telefone: ");
            telefoneInput = lerDados.lerTexto("\nPreencha o Campo de Telefone!\n");

            Telefone = RegexFunctions.formatarTelefone(telefoneInput);

        }


        return Telefone;
    }


    public static String VerificarEmailExiste(){

        var users = Txt_User.lerTudo();

        String Email;

        System.out.println("\nDigite seu E-mail: ");
        Email = lerDados.lerTexto("\nPreencha o Campo de E-mail!\n");

        while (ObjectUser.BuscarUser_Email(users ,Email).isPresent() || !RegexFunctions.validarEmail(Email)) {

            System.out.println("\nO E-mail digitado já existe ou não está no formato correto (username@domain.com)! Digite outro E-mail: ");
            Email = lerDados.lerTexto("\nPreencha o Campo de E-mail!\n");

        }

        return Email;
    }


    public static String VerificarEmail_NaoExiste(){

        var users = Txt_User.lerTudo();

        String Email;

        System.out.println("\nDigite seu E-mail: ");
        Email = lerDados.lerTexto("\nPreencha o Campo de E-mail!\n");

        while (ObjectUser.BuscarUser_Email(users, Email).isEmpty()) {

            System.out.println("\nO E-mail digitado não existe! Digite o seu E-mail novamente: ");
            Email = lerDados.lerTexto("\nPreencha o Campo de E-mail!\n");

        }

        return Email;
    }


    public static void Login(){

        var users = Txt_User.lerTudo();

        String Email = VerificarEmail_NaoExiste();

        System.out.println("\nDigite sua senha: ");
        String Senha = lerDados.lerTexto("\nPreencha o Campo de Senha!\n");

        while (ObjectUser.BuscarUser_EmaileSenha(users, Email, Senha).isEmpty()) {

            System.out.println("\nA senha digitada está incorreta! Digite sua senha novamente: ");
            Senha = lerDados.lerTexto("\nPreencha o Campo de Senha!\n");

        }

        var infosLogin = ObjectUser.BuscarUser_EmaileSenha(users, Email, Senha);

        var teste = List.of(infosLogin.get().Nome(), infosLogin.get().Sobrenome(), infosLogin.get().Email());

        TxtLogado.salvarTudo(teste);

        System.out.println("\n---------- Usuário logado! ---------");

        MenuPrincipal.PrincipalMenu();

    }

    public static String Retornar_EmailLogado(){

        var UserLogado_Infos = TxtLogado.lerTudo();

        String EmailLogado = UserLogado_Infos.getLast();

        return EmailLogado;

    }

    public static String Retornar_NomeLogado(){

        var UserLogado_Infos = TxtLogado.lerTudo();

        String NomeLogado = UserLogado_Infos.getFirst();

        return NomeLogado;

    }

    public static String Retornar_SobrenomeLogado(){

        var UserLogado_Infos = TxtLogado.lerTudo();

        String SobrenomeLogado = UserLogado_Infos.get(1);

        return SobrenomeLogado;

    }

}
