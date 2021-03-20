#include <stdio.h>
#include <algorithm>

typedef struct {
	int keyNum;
	int sec;
	char c;
}KeyInput;

int N, M;
KeyInput input[1001];
/*
void quickSort(int left, int right)
{
	int leftIndex = left;
	int rightIndex = right;
	int pivot = (left + right) / 2;

	while (leftIndex <= rightIndex)
	{
		while (input[leftIndex].sec < input[pivot].sec || (input[leftIndex].sec == input[pivot].sec && input[leftIndex].keyNum < input[pivot].keyNum)) {
			leftIndex++;
		}
		while (input[rightIndex].sec > input[pivot].sec || (input[rightIndex].sec == input[pivot].sec && input[rightIndex].keyNum > input[pivot].keyNum)) {
			rightIndex--;
		}

		if (leftIndex <= rightIndex) {
			KeyInput temp = input[leftIndex];
			input[leftIndex] = input[rightIndex];
			input[rightIndex] = temp;

			leftIndex++;
			rightIndex--;
		}
	}

	if (leftIndex < right) quickSort(leftIndex, right);
	if (left < rightIndex) quickSort(left, rightIndex);
}
*/

bool cmp(const KeyInput& a, const KeyInput& b) {
	if (a.sec == b.sec) return a.keyNum < b.keyNum;
	return a.sec < b.sec;
}

int main()
{
	scanf("%d %d", &N, &M);
	for (register int i = 0; i < M; i++) {
		scanf("%d %d %c", &input[i].keyNum, &input[i].sec, &input[i].c);
	}
	std::sort(input, input + M, cmp);
	for (register int i = 0; i < M; i++) {
		printf("%c", input[i].c);
	}
	printf("\n");
	return 0;
}