#include "NumRand.h"

#include <time.h>
#include <stdlib.h>

int NumRand::generar_numrand() {
    int num = 0;
    srand(time(NULL));
    for (int i = 1; i <= 10; i++)
    {
        num = 1 + rand() % (100 - 1);
    }
    return num;
}

