#include <iostream>
using namespace std;

char A[10002], B[10002], result[10002];
int aSize, bSize, num, aIndex, bIndex, rCnt;

int main()
{
	scanf("%s %s", A, B);
	while (A[aSize] != '\0') aSize++;
	while (B[bSize] != '\0') bSize++;
	
	aIndex = aSize - 1;
	bIndex = bSize - 1;
	int carry = 0;
	while (aIndex >= 0 && bIndex >= 0) {
		num = (A[aIndex] - '0') + (B[bIndex] - '0') + carry;
		if (num >= 10) {
			num -= 10;
			carry = 1;
		}
		else carry = 0;

		result[rCnt++] = num + '0';
		aIndex--;
		bIndex--;
	}

	for (; aIndex >= 0; aIndex--)
	{
		num = (A[aIndex] - '0') + carry;
		if (num >= 10) {
			num -= 10;
			carry = 1;
		}
		else carry = 0;

		result[rCnt++] = num + '0';
	}
	
	for (; bIndex >= 0; bIndex--) {
		num = (B[bIndex] - '0') + carry;
		if (num >= 10) {
			num -= 10;
			carry = 1;
		}
		else carry = 0;

		result[rCnt++] = num + '0';
	}
	if (carry == 1) result[rCnt++] = '1';
	for (register int i = rCnt - 1; i >= 0; i--) {
		printf("%c", result[i]);
	}
	printf("\n");
	return 0;
}