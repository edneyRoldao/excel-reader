package excelProject.importSheet.mirror;

import excelProject.importSheet.annotation.SpreadsheetField;
import excelProject.importSheet.annotation.SpreadsheetFieldRequired;

/**
 * Objeto que armazena os dados da planiha do import massivo para novos produtos.
 * Cada objeto representa um produto (linha) da planilha.
 *
 * @author edneyroldao
 * @since 22/12/2017
 */
public class NewProductSheet extends SpreadsheetMirror {

    @SpreadsheetFieldRequired
    @SpreadsheetField(name = "Categoria Marketplace (N1*>N2*<N3)")
    private String categoriaMarketplace;

    @SpreadsheetFieldRequired
    private String nomeProduto;

    private String descricaoProduto;

    @SpreadsheetFieldRequired
    private String skuLojista;

    private String skuViaVarejo;

    private String codigoAgrupador;

    @SpreadsheetFieldRequired
    private String estoque;

    private String eanOuIsbn;

    @SpreadsheetFieldRequired
    private String marca;

    @SpreadsheetFieldRequired
    private String precoDeVenda;

    @SpreadsheetFieldRequired
    private String altura;

    @SpreadsheetFieldRequired
    private String largura;

    @SpreadsheetFieldRequired
    private String profundidade;

    @SpreadsheetFieldRequired
    private String peso;

    private String tempoCompraFabricacao;

    private String garantia;

    @SpreadsheetFieldRequired
    private String urlImagem1;

    private String urlImagem2;

    private String urlImagem3;

    private String urlImagem4;

    private String atributo1;

    private String valores1;

    private String atributo2;

    private String valores2;

    private String atributo3;

    private String valores3;

    private String atributo4;

    private String valores4;

    private String atributo5;

    private String valores5;

    private String atributo6;

    private String valores6;

    private String atributo7;

    private String valores7;

    private String atributo8;

    private String valores8;

    private String atributo9;

    private String valores9;

    private String atributo10;

    private String valores10;

    public String getCategoriaMarketplace() {
        return categoriaMarketplace;
    }

    public void setCategoriaMarketplace(String categoriaMarketplace) {
        this.categoriaMarketplace = categoriaMarketplace;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getSkuLojista() {
        return skuLojista;
    }

    public void setSkuLojista(String skuLojista) {
        this.skuLojista = skuLojista;
    }

    public String getSkuViaVarejo() {
        return skuViaVarejo;
    }

    public void setSkuViaVarejo(String skuViaVarejo) {
        this.skuViaVarejo = skuViaVarejo;
    }

    public String getCodigoAgrupador() {
        return codigoAgrupador;
    }

    public void setCodigoAgrupador(String codigoAgrupador) {
        this.codigoAgrupador = codigoAgrupador;
    }

    public String getEstoque() {
        return estoque;
    }

    public void setEstoque(String estoque) {
        this.estoque = estoque;
    }

    public String getEanOuIsbn() {
        return eanOuIsbn;
    }

    public void setEanOuIsbn(String eanOuIsbn) {
        this.eanOuIsbn = eanOuIsbn;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPrecoDeVenda() {
        return precoDeVenda;
    }

    public void setPrecoDeVenda(String precoDeVenda) {
        this.precoDeVenda = precoDeVenda;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getLargura() {
        return largura;
    }

    public void setLargura(String largura) {
        this.largura = largura;
    }

    public String getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(String profundidade) {
        this.profundidade = profundidade;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getTempoCompraFabricacao() {
        return tempoCompraFabricacao;
    }

    public void setTempoCompraFabricacao(String tempoCompraFabricacao) {
        this.tempoCompraFabricacao = tempoCompraFabricacao;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public String getUrlImagem1() {
        return urlImagem1;
    }

    public void setUrlImagem1(String urlImagem1) {
        this.urlImagem1 = urlImagem1;
    }

    public String getUrlImagem2() {
        return urlImagem2;
    }

    public void setUrlImagem2(String urlImagem2) {
        this.urlImagem2 = urlImagem2;
    }

    public String getUrlImagem3() {
        return urlImagem3;
    }

    public void setUrlImagem3(String urlImagem3) {
        this.urlImagem3 = urlImagem3;
    }

    public String getUrlImagem4() {
        return urlImagem4;
    }

    public void setUrlImagem4(String urlImagem4) {
        this.urlImagem4 = urlImagem4;
    }

    public String getAtributo1() {
        return atributo1;
    }

    public void setAtributo1(String atributo1) {
        this.atributo1 = atributo1;
    }

    public String getValores1() {
        return valores1;
    }

    public void setValores1(String valores1) {
        this.valores1 = valores1;
    }

    public String getAtributo2() {
        return atributo2;
    }

    public void setAtributo2(String atributo2) {
        this.atributo2 = atributo2;
    }

    public String getValores2() {
        return valores2;
    }

    public void setValores2(String valores2) {
        this.valores2 = valores2;
    }

    public String getAtributo3() {
        return atributo3;
    }

    public void setAtributo3(String atributo3) {
        this.atributo3 = atributo3;
    }

    public String getValores3() {
        return valores3;
    }

    public void setValores3(String valores3) {
        this.valores3 = valores3;
    }

    public String getAtributo4() {
        return atributo4;
    }

    public void setAtributo4(String atributo4) {
        this.atributo4 = atributo4;
    }

    public String getValores4() {
        return valores4;
    }

    public void setValores4(String valores4) {
        this.valores4 = valores4;
    }

    public String getAtributo5() {
        return atributo5;
    }

    public void setAtributo5(String atributo5) {
        this.atributo5 = atributo5;
    }

    public String getValores5() {
        return valores5;
    }

    public void setValores5(String valores5) {
        this.valores5 = valores5;
    }

    public String getAtributo6() {
        return atributo6;
    }

    public void setAtributo6(String atributo6) {
        this.atributo6 = atributo6;
    }

    public String getValores6() {
        return valores6;
    }

    public void setValores6(String valores6) {
        this.valores6 = valores6;
    }

    public String getAtributo7() {
        return atributo7;
    }

    public void setAtributo7(String atributo7) {
        this.atributo7 = atributo7;
    }

    public String getValores7() {
        return valores7;
    }

    public void setValores7(String valores7) {
        this.valores7 = valores7;
    }

    public String getAtributo8() {
        return atributo8;
    }

    public void setAtributo8(String atributo8) {
        this.atributo8 = atributo8;
    }

    public String getValores8() {
        return valores8;
    }

    public void setValores8(String valores8) {
        this.valores8 = valores8;
    }

    public String getAtributo9() {
        return atributo9;
    }

    public void setAtributo9(String atributo9) {
        this.atributo9 = atributo9;
    }

    public String getValores9() {
        return valores9;
    }

    public void setValores9(String valores9) {
        this.valores9 = valores9;
    }

    public String getAtributo10() {
        return atributo10;
    }

    public void setAtributo10(String atributo10) {
        this.atributo10 = atributo10;
    }

    public String getValores10() {
        return valores10;
    }

    public void setValores10(String valores10) {
        this.valores10 = valores10;
    }
}
