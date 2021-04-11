#ifndef TOPERACIONMATRIZ_H_INCLUDED
#define TOPERACIONMATRIZ_H_INCLUDED

template <class T>
class TOperacionMatriz {
public:
	void proceso(T**, T**, T**, T);
};

template <class T>
void TOperacionMatriz<T>::proceso(T** mat1, T** mat2, T** matr, T d) {
    for (int i = 0; i < d; i++) {
        for (int j = 0; j < d; j++) {
            for (int k = 0; k < d; k++) {
                *(*(matr + i) + j) = *(*(matr + i) + j) + (*(*(mat1 + i) + k)) * (*(*(mat2 + k) + j));
            }
        }
    }
}

#endif
