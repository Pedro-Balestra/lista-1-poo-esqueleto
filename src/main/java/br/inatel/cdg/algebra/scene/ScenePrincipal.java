package br.inatel.cdg.algebra.scene;

import br.inatel.cdg.algebra.reta.Ponto;
import br.inatel.cdg.algebra.reta.Reta;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScenePrincipal {

    private Button btnAngular, btnLinear; //Button representa botoes
    private Label labelP1x,labelP2x,labelP1y,labelP2y; //Label representam rótulos
    private TextField textP1x, textP2x,textP2y,textP1y,textAngular,textLinear; //TextField Representam áreas de texto

    public void criaScenePrincipal(Stage stage){

        //Criando os labels para os pontos e os campos de texto para os dados
        labelP1x = new Label("P1.x"); //rótulos
        textP1x = new TextField(); //área de texto onde vc digitara alguma coisa

        labelP1y = new Label("P1.y");
        textP1y = new TextField();

        labelP2x = new Label("P2.x");
        textP2x = new TextField();

        labelP2y = new Label("P2.y");
        textP2y = new TextField();


        //HBox é usado para agrupar elementos horizontalmente
        HBox hP1x = new HBox(labelP1x, textP1x); //Passamos no construtor todos os elementos. Você poderá criar vários grupos horizontais
        HBox hP1y = new HBox(labelP1y, textP1y);
        HBox hP2x = new HBox(labelP2x, textP2x);
        HBox hP2y = new HBox(labelP2y, textP2y);

        VBox hboxEntrada = new VBox(hP1x,hP1y,hP2x,hP2y);

        //Agora vamos criar a area que mostrará o que foi digitado
        textAngular = new TextField();
        textAngular.setEditable(false);//vamos deixar false para apenas mostrar texto
        textAngular.setText("Coeficiente Angular: ");

        textLinear = new TextField();
        textLinear.setEditable(false);//vamos deixar false para apenas mostrar texto
        textLinear.setText("Coeficiente Linear: ");

        HBox hboxResposta = new HBox(textAngular,textLinear);

        //Criamos o botão
        btnAngular = new Button("Calcular coeficiente Angular");
        //Criamos a ação que o botão responderá as ser pressionado
        btnAngular.setOnAction(evento -> {
            //Aqui dentro é a ação que será executado ao pressionar o botão
            Reta reta = construirReta();
            textAngular.setText("Coeficiente Angular: " + reta.coeficienteAngular());//Acessamos o componente textField1, pegamos o texto e colocaos em textField2
        });
        btnLinear = new Button("Calcular coeficiente Linear");
        btnLinear.setOnAction(evento -> {
            Reta reta = construirReta();
            textLinear.setText("Coeficiente Linear: " + reta.coeficienteLinear());
        });

        HBox hboxBotao = new HBox(btnAngular,btnLinear);

        //VBox é usada para agrupar elementos verticalmente
        //No construtor passamos todos os elementos que serão agrupados, que podem ser outros grupos
        VBox layoutFinal = new VBox(hboxEntrada, hboxResposta,hboxBotao);//Aqui vamos agrupar verticalmente o grupo (Label + Texto) o Botao e A area que aparecer o texto digitado

        //Criamos a Scene
        Scene scene = new Scene(layoutFinal, 300 , 200);

        stage.setTitle("Software Para Calculos de Álgebra Linear");
        stage.setScene(scene);
        stage.show();
    }
    //Função interna que cria uma reta!
    private Reta construirReta(){
        Ponto p1 = new Ponto(Double.parseDouble(textP1x.getText()),
                Double.parseDouble(textP1y.getText()));

        Ponto p2 = new Ponto(Double.parseDouble(textP2x.getText()),
                Double.parseDouble(textP2y.getText()));

        Reta reta = new Reta(p1,p2);
        return reta;
    }

}
