/* Autores:
Cabascango Abigail
Chuquimarca Kevin
Andrade Kenneth
Requerimientos:
Fecha: 23/06/2019*/

#include<stdio.h>						//librerías para el programa
#include<stdlib.h>
#include<windows.h>
#include<time.h>

void carga_tablero(FILE *, int**, int, int, int);		//función para cargar datos en la matriz dinámica

void carga_fichero(FILE *, int **, int, int);			//Función para cargar datos en el fichero

void impresion_fichero(FILE *, int **, int, int);		//Función para imprimir la información del fichero

int f_juego(FILE *, int**, int, int, int);				//función para el proceso del juego

main(){
	FILE *pfile;
	int nf, nc, **ptbl, juego, num_minas, aux;			//declaraciónn de variables
	for (int i=0; i<5; i++){													//ciclo dinámico para la bienvenida
		printf("\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t       BIENVENIDOS AL BUSCAMINAS");
		printf("\n\n\n\t\t\t\t\tINGENIERIA DE SOFTWARE\n\n");
		Sleep(1000);															//funcion para esperar en milisegundos
		system("cls");															//borrado de pantalla
		Sleep(1000);
	}
	printf("Reglas del juego\n");												//reglas del juego
	printf("\n1. El juego consiste en no ingresar una coordenada que contenga una mina\n");
	printf("\n2. El numero minimo de minas debe ser mayor al numero de filas\n");
	printf("\n3. El numero maximo de minas debe ser menor a (nf*nc)-10\n");
	printf("\n4. El tamaño de la matriz (minimo[5][5]/maximo[15][15])\n\n");
	system("pause");																//esperar una tecla y borrar pantalla
	system("cls");
	do{
		printf("1. Comenzar el juego\n\n");											//ingreso de opciones para jugar o salir
		printf("0. Salir\n\n");
		do{
			printf("Ingrese su opcion: ");
			scanf("%d", &juego);
		}while(juego<0 or juego>1);
		if (juego==0){
			return 0;
		}
		system("cls");
		do{
			printf("Tamaño minimo de la matriz[5][5] y maximo[15][15]\n\n");
			printf("Ingrese el numero de filas: ");						//carga del número de filas  columnas
			scanf("%d", &nf);
			printf("\nIngrese el numero de columnas: ");				//ingreso del número de filas y columnas
			scanf("%d", &nc);
			system("cls");
			printf("Matriz fuera de rango\n\n");
			if (nf<5 && nf>15 && nc<5 && nc>15)
			printf("Matriz fuera de rango\n");
		}while ((nf<5 or nf>15) or (nc<5 or nc>15));
		system("cls");
		if ((ptbl=(int**)malloc(nf*sizeof(int*)))==NULL){					// creación de la matriz dinámica en filas
			printf("Error en la reserva dinamica de memoria para filas");
			exit(1);
		}
		for (int i=0; i<nf; ++i){																			
			if ((ptbl[i]=(int*)malloc(nc*sizeof(int)))==NULL){					
				printf("Error en la reserva dinamica de para columnas");
				exit(1);
			}
		}
		do{
			printf("Numero de minas entre %d y %d\n\n", nf, (nf*nc)-10);		//ingreso del número de minas
			printf("Ingrese el numero de minas: ");
			scanf("%d", &num_minas);
			system("cls");
			printf("El numero de minas es incorrecto\n\n");
		}while(num_minas<nf or num_minas>(nf*nc)-10);
		system("cls");	
		if ((pfile=fopen("buscaminas.txt","wt"))==NULL){						//apertura del fichero
			printf("Problemas al abrir el fichero del tablero\n");
		}
		fprintf(pfile, "%d %d \n", nf, nc);
		carga_tablero(pfile, ptbl, nf, nc, num_minas);
		carga_fichero(pfile, ptbl, nf, nc);
		fclose(pfile);
		aux=1;
		do{												//ciclo para el juego
			if (aux==1){
				printf("Si usted encuentra una mina pierde\n\nNumero de minas: %d\n\nJugue con cuidado\n\n", num_minas);
				impresion_fichero(pfile, ptbl, nf, nc);
				aux=f_juego(pfile, ptbl, nf, nc, num_minas);	
				system("cls");
				carga_fichero(pfile, ptbl, nf, nc);
			}
			if (aux==0){
				carga_fichero(pfile, ptbl, nf, nc);
				printf("Usted Perdio\n\nSuerte la proxima vez\n\n");
				for (int i=0; i<nf; i++){
    				for	(int j=0; j<nc; j++){
    					switch (ptbl[i][j]){				//impresión final de la matriz cuando pierda
							case -4:
								printf("  ");
							break;	
							case -5:
								printf("* ");
							break;	
							case -1:
								printf("  ");
							break;	
							case -2:
								printf("* ");
							break;
								case -3:
								printf("3 ");
							break;
						}
					}
					printf("\n");
    			}
				Sleep(8000);
				system("cls");
			}
		}while(aux!=0);
	}while (juego==1);				//ciclo para repetir
}

void carga_tablero(FILE *pfile, int **ptbl, int nf, int nc, int num_minas){		
	int num, num1;			//carga de datos en la matriz
	for (int i=0; i<nf; i++){
    	for	(int j=0; j<nc; j++){
			ptbl[i][j]=-1;
 	   }
    }
	srand(time(NULL));						//función randimica para la asignación de minas
	for (int i=0; i<num_minas; i++){
			num=0+rand() % (nf-1);	
			num1=0+rand() % (nc-1);
			ptbl[num][num1]=-2;
		}
   	for	(int i=0; i<num_minas/2; i++){
		num=1+rand() % (nf-2);	
		num1=1+rand() % (nc-2);
		ptbl[num][num1]=-3;
    }
}

void carga_fichero(FILE *pfile, int **ptbl, int nf, int nc){
	for (int i=0; i<nf; i++){
    	for	(int j=0; j<nc; j++){
			fprintf(pfile, "%d ", ptbl[i][j]);			//impresión de información en el fichero
 	   }
 	   fputs("\n", pfile);
    }
}

void impresion_fichero(FILE *pfile, int **ptbl, int nf, int nc){
	for (int i=0; i<nf; i++){
    	for	(int j=0; j<nc; j++){
				switch (ptbl[i][j]){			//impresión de la matriz
					case -4:
						printf("  ");
					break;	
					case -5:
						printf("* ");
					break;	
					case -1:
						printf("? ");
					break;	
					case -2:
						printf("? ");
					break;
					case -3:
						printf("? ");
					break;
				}
 	   }
 	   printf("\n");
    }
}

int f_juego(FILE *pfile, int **ptbl, int nf, int nc, int num_minas){
	int pos_af, pos_ac, aux2;
	do{
		aux2=1;
		printf("\nIngrese las coordenadas de la casilla [FILA]: ");			//ingreso de las coordenadas de ataque
		scanf("%d", &pos_af);
		printf("\nIngrese las coordenadas de la casilla [COLUMNA]: ");
		scanf("%d", &pos_ac);
		if (pos_af>=0 && pos_af<nf && pos_ac>=0 && pos_ac<nc){
			if (ptbl[pos_af][pos_ac]==-4){								//validación del ataque
				printf("\n\nLa posicion ya ha sido atacada");
				Sleep(2000);
			}
			if (ptbl[pos_af][pos_ac]==-1){
				ptbl[pos_af][pos_ac]=-4;
				printf("\n\nNo hay mina");
				Sleep(2000);
			}
			if (ptbl[pos_af][pos_ac]==-2){
				ptbl[pos_af][pos_ac]=-5;
				printf("\n\nMal\n\nEncontro una mina");
				aux2=0;
				Sleep(2000);
			}
			if (ptbl[pos_af][pos_ac]==-3){
				for (int i=pos_af-1; i<pos_af+2; i++){
					for (int j=pos_ac-1; j<pos_ac+2; j++){
						if (ptbl[i][j]==-1 or ptbl[i][j]==-3)
						ptbl[i][j]=-4;
					}	
				}
				printf("\n\nCombo!!!");	
				Sleep(2000);
			}
		}
		printf("\n\nvalor aux %d\n\n", aux2);	
	}while(pos_af<0 or pos_af>=nf or pos_ac<0 or pos_ac>=nc);
	pfile=fopen("buscaminas.txt","wt");								//actualización de datos en el fichero
	fprintf(pfile, "%d %d \n", nf, nc);
	for (int i=0; i<nf; i++){
		for (int j=0; j<nc; j++){
			fprintf(pfile, "%d ", ptbl[i][j]);
		}
			fputs("\n", pfile);
	}
	fclose(pfile);
	printf("\n\nvalor ......%d\n\n", aux2);
	return (aux2);												//retorno para finalizar el juego
}

