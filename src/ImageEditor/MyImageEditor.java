package Image-Editor;

//import java.awt.Color;
import java.io.File;

import processing.core;

public class MyImageEditor extends PApplet {

  public void settings(){
	  bottonPosition = 9;
	  size(800, 600);
  }
  public void setup(){
	  createPanel();
	  
  }
  
  Button bt = new Button();
  ImageMan img = new ImageMan();
  int rgb, yuv, RGBset, YUVset, cset;
  int bottonPosition;
  
  public void draw(){
	  createPanel();
	  show();
  }
  
 
  class Button{
	  	 
	  public Button(){
		  rgb = color(55, 71, 79);
		  yuv = color(0, 77, 64);
		  RGBset = color(176, 190, 197);// colore premuto
		  YUVset = color(128, 203, 196); // colore premuto
		  cset = color(	189, 189, 189); // colore premuto
	  };
	  
	  public void createButton(){
		  // panel A
		  if(bottonPosition == 1) fill(RGBset);
		  else fill(rgb);
		  rect(10, 30, 80, 50, 7); // RGB button 
		  if(bottonPosition == 2) fill(RGBset);
		  else fill(rgb);
		  rect(20, 120, 60, 60, 7); // R button
		  if(bottonPosition == 3) fill(RGBset);
		  else fill(rgb);
		  rect(20, 220, 60, 60, 7); // G button
		  if(bottonPosition == 4) fill(RGBset);
		  else fill(rgb);
		  rect(20, 320, 60, 60 ,7); // B button
		  fill(0xffF5F5F5);
		  rect(15, 430, 70, 50, 7); // SALE button
		  fill(0xff000000);
		  rect(15, 520, 70, 50, 7); // PEPE button
		  //panel C
		  if(bottonPosition == 5) fill(YUVset);
		  else fill(yuv);
		  rect(710, 290, 80, 60 ,7); // YUV button
		  if(bottonPosition == 6) fill(YUVset);
		  else fill(yuv);
		  rect(715, 380, 70, 50, 7); // Y button
		  if(bottonPosition == 7) fill(YUVset);
		  else fill(yuv);
		  rect(715, 450, 70, 50, 7); // U button
		  if(bottonPosition == 8) fill(YUVset);
		  else fill(yuv);
		  rect(715, 520, 70, 50, 7); // V button
		  //panel B
		  fill(0xff26A69A);
		  rect(725, 30, 50, 50, 7); // 3x3 button 
		  rect(725, 110, 50, 50, 7); // 5x5 button
		  rect(725, 190, 50, 50, 7); // 7x7 button		  
		  //panel C
		  if(img.loaded) fill(cset);
		  else fill(0xff424242);
		  rect(325, 525, 150, 60); // Reset button
		  rect(512, 525, 150, 60); // Save button
		  if(bottonPosition == 9 || img.loaded == true) fill(cset);
		  else fill(0xff424242);
		  rect(138, 525, 150, 60); // Open button 
		  
		  //name of button
		  
		  textAlign(CENTER);
		  textSize(30);
		  fill(50);
		  text("RGB", 50, 65);
		  fill(255,0,0);
		  text("R", 50, 160);
		  fill(0,255,0);
		  text("G", 50, 260);
		  fill(0,0,255);
		  text("B", 50, 360);
		  fill(0);
		  textSize(27);
		  text("SALE", 50, 465);
		  fill(250);
		  text("PEPE", 50, 555);
		  fill(0);
		  textSize(25);
		  text("3", 750, 65);
		  text("5", 750, 145);
		  text("7", 750, 225);
		  fill(50);
		  textSize(30);
		  text("YUV", 750, 330);
		  textSize(27);
		  text("Y", 750, 415);
		  text("U", 750, 485);
		  text("V", 750, 555);
		  textSize(35);
		  text("OPEN", 213, 570);
		  text("RESET", 400, 570);
		  text("SAVE", 587, 570);
	  }
	  
	  public Boolean checkOpen(){
			  if(mouseX >= 138 && mouseX <= 288){
				  if(mouseY >= 525 && mouseY <= 585){
					  bottonPosition = 9;
					 return true;
				  }
			  }
			  return false;
	  }
	  
	  public Boolean checkReset(){
		  if(mouseX >= 325 && mouseX <= 475){
			  if(mouseY >= 525 && mouseY <= 585){
				 return true;
			  }
		  }
		  return false;
	  } 
	  
	  public Boolean checkSave(){
		  if(mouseX >= 512 && mouseX <= 662){
			  if(mouseY >= 525 && mouseY <= 585){
				 return true;
			  }
		  }
		  return false;
	  } 
	  
	  public Boolean checkRed(){
		  if(mouseX >= 20 && mouseX <= 80){
			  if(mouseY >= 120 && mouseY <= 180){
				  bottonPosition = 2;
				 return true;
			  }
		  }
		  return false;
	  }
	  
	  public Boolean checkGreen(){
		  if(mouseX >= 20 && mouseX <= 80){
			  if(mouseY >= 220 && mouseY <= 280){
				  bottonPosition = 3;
				 return true;
			  }
		  }
		  return false;
	  }
	  
	  public Boolean checkBlue(){
		  if(mouseX >= 20 && mouseX <= 80){
			  if(mouseY >= 320 && mouseY <= 380){
				  bottonPosition = 4;
				 return true;
			  }
		  }
		  return false;
	  }
	  
	  public Boolean checkRGB(){
		  if(mouseX >= 10 && mouseX <= 90){
			  if(mouseY >= 30 && mouseY <= 80){
				  bottonPosition = 1;
				 return true;
			  }
		  }
		  return false;
	  }
	  
	  public Boolean check3x3(){
		  if(mouseX >= 725 && mouseX <= 775){
			  if(mouseY >= 30 && mouseY <= 80){
				 return true;
			  }
		  }
		  return false;
	  }
	  
	  public Boolean check5x5(){
		  if(mouseX >= 725 && mouseX <= 775){
			  if(mouseY >= 110 && mouseY <= 160){
				 return true;
			  }
		  }
		  return false;
	  
	  }
	  public Boolean check7x7(){
		  if(mouseX >= 725 && mouseX <= 775){
			  if(mouseY >= 190 && mouseY <= 240){
				 return true;
			  }
		  }
		  return false;
	  }
	  
	  public Boolean checkSale(){
		  if(mouseX >= 15 && mouseX <= 85){
			  if(mouseY >= 430 && mouseY <= 480){
				 return true;
			  }
		  }
		  return false;
	  }
	  
	  public Boolean checkPepe(){
		  if(mouseX >= 15 && mouseX <= 85){
			  if(mouseY >= 520 && mouseY <= 570){
				 return true;
			  }
		  }
		  return false;
	  }
	  
	  public Boolean checkYUV(){
		  if(mouseX >= 710 && mouseX <= 790){
			  if(mouseY >= 290 && mouseY <= 350){
				  bottonPosition = 5;
				 return true;
			  }
		  }
		  return false;
	  }
	  
	  public Boolean checkY(){
		  if(mouseX >= 715 && mouseX <= 785){
			  if(mouseY >= 380 && mouseY <= 430){
				  bottonPosition = 6;
				 return true;
			  }
		  }
		  return false;
	  }
	  public Boolean checkU(){
		  if(mouseX >= 715 && mouseX <= 785){
			  if(mouseY >= 450 && mouseY <= 500){
				  bottonPosition = 7;
				 return true;
			  }
		  }
		  return false;
	  }
	  public Boolean checkV(){
		  if(mouseX >= 715 && mouseX <= 785){
			  if(mouseY >= 520 && mouseY <= 570){
				  bottonPosition = 8;
				 return true;
			  }
		  }
		  return false;
	  }
	  
  }
  
  class ImageMan{
	  public PImage originpic;
	  public PImage savepic;
	  public PImage currpic;
	  public PImage channelpic;
	  public PImage yuv_img;
	  public Boolean loaded = false;
	  public int resw;
	  public int resh;
	  
	  public ImageMan(){ }
	  
	  public void loadPic(){
		  selectInput("Scegli l'immagine da modificare : ", "fileSelected"); // carica l'immagine
	  }
	  
	  public void saveImage(){
		 selectOutput("Scegli la destinazione: ", "secelctOutput" );
	  }
	  
	  public void checkSize(){
		  if(this.originpic.width > 600 || this.originpic.height > 500){
				img.resizePic();
			}
		  else{
			  img.setCurrImage(img.originpic);
		  	  this.resw = 600;
		  	  this.resh = 500;
		  }
		  	
	  }
	  
	  public void resizePic(){
		  if(this.originpic.width > this.originpic.height){
			  this.resw = 600;
			  this.resh =( (600 * this.originpic.height)/ this.originpic.width );
		  }
		  else{
			  this.resh = 500;
			  this.resw =( (500 * this.originpic.width)/ this.originpic.height );
		  }
	  }
	  
	  public void setCurrImage(PImage _img){
		  img.currpic = _img.copy();
	  }
	  
	  public PImage getCurrImg(){
		  return this.currpic;
	  }
	  
	  public PImage RGBChannel(){
		  img.savepic.loadPixels();
		  for(int i=0; i < savepic.pixels.length; i++){
			  	  savepic.pixels[i] = color( red(savepic.pixels[i]), green(savepic.pixels[i]), blue(savepic.pixels[i]));
		  }
		  savepic.updatePixels();
		  return this.savepic;
	  }
	  
	  public PImage redChannel(){  //visualizza solo il canale rosso dell'immagine in input
		  img.channelpic = img.savepic.copy();
		  channelpic.loadPixels();
		  for(int i=0; i < currpic.pixels.length; i++){
			  channelpic.pixels[i] = color( red(savepic.pixels[i]));
		  }
		  channelpic.updatePixels();
		  return this.channelpic;
	  }
	  public PImage greenChannel(){  //visualizza solo il canale del verde dell'immagine in input
		  img.channelpic = img.savepic.copy();
		  channelpic.loadPixels();
		  for(int i=0; i < savepic.pixels.length; i++){
			  channelpic.pixels[i] = color(green(savepic.pixels[i]));
		  }
		  channelpic.updatePixels();  
		  return this.channelpic;
	  }
	  public PImage blueChannel(){  //visualizza solo il canale del verde dell'immagine in input
		  img.channelpic = img.savepic.copy();
		  channelpic.loadPixels();
		  for(int i=0; i < savepic.pixels.length; i++){
			  channelpic.pixels[i] = color(blue(savepic.pixels[i]));
		  }
		  channelpic.updatePixels();
		  return this.channelpic;
	  }
	  
	  public PImage applyMedian(PImage img_input, int input){
		  
		  PImage new_img = createImage(img_input.width, img_input.height, RGB);
		  PImage temp_img;
		  int centre = input/2;
		  int[] col;
		  int median;
		  int pos;
		  
		  for(int i=input; i < img_input.width-input; i++){
			  for(int j=input; j < img_input.height-input; j++){
				  temp_img = img_input.get(max(0, i-centre), max(0, j-centre), min(input, img_input.width-i), min(input, img_input.height-j));
				 
				  temp_img.loadPixels();
				  
				  col=sort(temp_img.pixels);
				  
				  pos = col.length/2;
				  
				  if(col.length%2 == 1){
					  median = col[pos];
				  }
				  else{
					  median = color(red(col[pos]) +  red(col[pos-1]))/2;
				  }
				  new_img.set(i, j, median);
			  }
		  }
		  return new_img;
	  }
	 	  
	  public PImage YUVChannel(){
		  yuv_img = savepic.copy();
		  img.yuv_img.loadPixels();
		  float R, G, B, Y, U, V;
		  
		  for(int i=0; i < yuv_img.pixels.length; i++){
			R = (red(yuv_img.pixels[i]));
			G = (green(yuv_img.pixels[i]));
			B = (blue(yuv_img.pixels[i]));
			Y = (float)(0.3 * R + 0.6 * G + 0.1 * B);
			U = (float)(((B-Y)/2)+ 114.75);
			V = (float)(((R-Y)/2) + 111.57);
			yuv_img.pixels[i] = color(Y, U, V);
		  }
		  yuv_img.updatePixels();
		  return this.yuv_img;
	  }
	  
	  public PImage YChannel(){
		  yuv_img = savepic.copy();
		  img.yuv_img.loadPixels();
		  float R, G, B, Y;
		  
		  for(int i=0; i < yuv_img.pixels.length; i++){
			R = (red(yuv_img.pixels[i]));
			G = (green(yuv_img.pixels[i]));
			B = (blue(yuv_img.pixels[i]));
			Y = (float)(0.3 * R + 0.6 * G + 0.1 * B);
			yuv_img.pixels[i] = color(Y);
		  	}
		  yuv_img.updatePixels();
		  return this.yuv_img;
		  
	  }
	  
	  public PImage UChannel(){
		  yuv_img = savepic.copy();
		  img.yuv_img.loadPixels();
		  float R, G, B, Y, U;
		  
		  for(int i=0; i < yuv_img.pixels.length; i++){
			R = (red(yuv_img.pixels[i]));
			G = (green(yuv_img.pixels[i]));
			B = (blue(yuv_img.pixels[i]));
			Y = (float)(0.3 * R + 0.6 * G + 0.1 * B);
			U = (float)(((B-Y)/2)+ 114.75);
			yuv_img.pixels[i] = color(U);
		  }
		  yuv_img.updatePixels();
		  return this.yuv_img;
	  }
	  
	  public PImage VChannel(){
		  yuv_img = savepic.copy();
		  img.yuv_img.loadPixels();
		  float R, G, B, Y, V;
		  
		  for(int i=0; i < yuv_img.pixels.length; i++){
			R = (red(yuv_img.pixels[i]));
			G = (green(yuv_img.pixels[i]));
			B = (blue(yuv_img.pixels[i]));
			Y = (float)(0.3 * R + 0.6 * G + 0.1 * B);
			V = (float)(((R-Y)/2) + 111.57);
			yuv_img.pixels[i] = color(V);
		  }
		  yuv_img.updatePixels();
		  return this.yuv_img;
		  
	  } 

	  
	  public PImage applySalt(){
		  
		  int point;
		  img.savepic.loadPixels();
		  
		  for(int i=0; i< savepic.pixels.length; i++){
			  
			  point = (int)random(1, 100);
			  
			  if(point  >= 1 && point <= 3){
				  img.savepic.pixels[i] = color(255);
			  }
			  
		  }
		  img.savepic.updatePixels();
		  
		  return img.savepic;
	  }
	  
 public PImage applyPepper(){
		  
		  int point;
		  
		  img.savepic.loadPixels();
		  
		  for(int i=0; i< savepic.pixels.length; i++){
			  
			  point = (int)random(1, 100);
			  
			  if(point  >= 1 && point <= 5){
				  this.savepic.pixels[i] = color(0);
			  }
			  
		  }
		  img.savepic.updatePixels();
		  return this.savepic;
	  }
 
 	public void resetAll(){
 		setCurrImage(this.originpic);
 		this.savepic = getCurrImg().copy();
 		this.channelpic = getCurrImg().copy(); 	
 		this.yuv_img = getCurrImg().copy();
 		bottonPosition = 9;
 	}
	
	  
  } // end class ImageMan
  
  public void checkLastButtonPress(){
	  if(bottonPosition == 2){ // verifica pressione tasto R
		  img.setCurrImage(img.redChannel());
	  }
	  if(bottonPosition == 3){ // verifica pressione tasto G
		  img.setCurrImage(img.greenChannel());
	  }
	  if(bottonPosition == 4){ // verifica pressione tasto B
		  img.setCurrImage(img.blueChannel());
	  }
	  if(bottonPosition == 5){ // verifica pressione tasto YUV
		  img.setCurrImage(img.YUVChannel());
	  }
	  if(bottonPosition == 6){ // verifica pressione tasto Y
		  img.setCurrImage(img.YChannel());
	  }
	  if(bottonPosition == 7){ // verifica pressione tasto U
		  img.setCurrImage(img.UChannel());
	  }
	  if(bottonPosition == 8){ // verifica pressione tasto V
		  img.setCurrImage(img.VChannel());
	  }
  }
  
  public void show(){
	  	bt.createButton();
	  	if(img.loaded){
	  		imageMode(CENTER);
	  		image(img.getCurrImg(), 400, 250, img.resw, img.resh);
	  	}
	  		
  	}
  public void secelctOutput(File selection) {
	  if (selection == null) {
	    println("Nulla da salvare! ");
	  } 
	  else {
	   img.currpic.save(savePath(selection.getAbsolutePath()));
	  }
	}
  
  public void fileSelected(File selection){
		String path=selection.getAbsolutePath();
			img.originpic = loadImage(path); // memorizza l'immagine
			img.currpic = loadImage(path);
			img.savepic = loadImage(path);
			img.checkSize();
			img.loaded=true;
	  }
  
  public void mouseClicked(){
	  
	  if(bt.checkOpen()){
		  img.loadPic();
	  }
	  
	 if(img.loaded != false){
	  
	  if(bt.checkReset()){
		  img.resetAll();
	  }
	  if(bt.checkRed()){
		  img.setCurrImage(img.redChannel());
	  }
	  if(bt.checkGreen()){
		 img.setCurrImage(img.greenChannel());
	  }
	  if(bt.checkBlue()){
		  img.setCurrImage(img.blueChannel());
	  }
	  if(bt.checkRGB()){
		  img.setCurrImage(img.RGBChannel());
	  }
	  if(bt.check3x3()){
		  img.setCurrImage(img.applyMedian(img.savepic, 5));
		  img.savepic = img.currpic.copy();
		  checkLastButtonPress();
	  }
	  if(bt.check5x5()){
		  img.setCurrImage(img.applyMedian(img.savepic, 5));
		  img.savepic = img.currpic.copy();
		  checkLastButtonPress();
	  }
	  if(bt.check7x7()){
		  img.setCurrImage(img.applyMedian(img.savepic, 5));
		  img.savepic = img.currpic.copy();
		  checkLastButtonPress();
	  }
	  if(bt.checkSale()){
		  img.setCurrImage(img.applySalt());
		  checkLastButtonPress();
	  }
	  if(bt.checkPepe()){
		  img.setCurrImage(img.applyPepper());
		  checkLastButtonPress();
		  }
	  if(bt.checkYUV()){
		  img.setCurrImage(img.YUVChannel());
	  }
	  if(bt.checkY()){
		  img.setCurrImage(img.YChannel());
	  }
	  if(bt.checkU()){
		  img.setCurrImage(img.UChannel());
	  }
	  if(bt.checkV()){
		  img.setCurrImage(img.VChannel());
	  }
	  if(bt.checkSave()){
		  img.saveImage();
	  }
	 }
	  
  }

  
  public void createPanel(){
	  rectMode(CORNER);
	  fill(0xff263238); 
	  rect(0, 0, 100, 599); // panel A
	  fill(0xff004D40);
	  rect(699, 0, 100, 599); // panel B
	  fill(0); // riquadro mediano
	  line(710, 5, 790, 5);// linea alta
	  line(710, 5, 710, 265); // linea sinistra
	  line(710, 265, 790, 265); // linea bassa
	  line(790, 5, 790, 265); // linea destra
	  textSize(15);
	  fill(0xff1E88E5);
	  textAlign(CORNER);
	  text(" MEDIANO", 708, 20);
	  fill(0xff212121);
	  rect(100, 500, 600, 99); // panel C
	  fill(0xff000000);
	  rect(100, 0, 600, 500); //panel D
  }
  

  
  
  }// end project