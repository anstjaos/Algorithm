#include <iostream>
using namespace std;

char A[31], B[31];
int aLen, bLen, aIndex = 0, bIndex = 0;

int strlen1(char *arr)
{
	int index = 0;
	while (arr[index] != '\0') index++;

	return index;
}

void findIndex()
{
	aIndex = -1;
	bIndex = -1;
	for (int i = 0; i < aLen; i++)
	{
		for (int j = 0; j < bLen; j++)
		{
			if (A[i] == B[j])
			{
				aIndex = i;
				bIndex = j;
				break;
			}
		}
		if (aIndex != -1 && bIndex != -1) break;
	}
}

int main()
{
	cin >> A >> B;
	aLen = strlen1(A);
	bLen = strlen1(B);

	findIndex();

	for (int i = 0; i < bLen; i++)
	{
		for (int j = 0; j < aLen; j++)
		{
			if (j == aIndex) cout << B[i];
			else if (i == bIndex) cout << A[j];
			else cout << '.';
		}
		cout << endl;
	}
	return 0;
}