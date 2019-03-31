#include <iostream>
#include <string>
using namespace std;

string A, B;
int minNum, maxNum;

int main()
{
	cin >> A >> B;
	int aSize = A.size();
	for (int i = 0; i < aSize; i++)
	{
		if (A[i] == '6') A[i] = '5';
	}
	int bSize = B.size();
	for (int i = 0; i < bSize; i++) if (B[i] == '6') B[i] = '5';

	minNum = stoi(A) + stoi(B);

	for (int i = 0; i < aSize; i++) if (A[i] == '5') A[i] = '6';
	for (int i = 0; i < bSize; i++) if (B[i] == '5') B[i] = '6';

	maxNum = stoi(A) + stoi(B);

	cout << minNum << " " << maxNum << "\n";
	return 0;
}