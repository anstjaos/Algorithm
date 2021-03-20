#include <iostream>
using namespace std;

long long n;

int main()
{
	cin >> n;
	n = n + 1;
	int index = 0;
	int temp = n;
	while (temp != 0)
	{
		temp = temp / 2;
		index++;
	}

	for (int i = index - 2; i >=0 ; i--)
	{
		if((n >> i) %2 ==  0) cout << "4";
		else cout << "7";
	}
	cout << endl;
}