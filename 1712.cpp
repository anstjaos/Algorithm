#include <iostream>
using namespace std;

int A, B, C;

int main()
{
	cin >> A >> B >> C;

	if (B >= C)
	{
		cout << "-1\n";
		return 0;
	}

	int result = A / (C - B);
	cout << result + 1 << "\n";
	return 0;
}