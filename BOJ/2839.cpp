#include <iostream>

using namespace std;

int main()
{
	int count = 0;
	int num;
	cin >> num;

	while (num > 0)
	{
		if (num % 5 == 0)
		{
			num = num - 5;
			count++;
		}
		else 
		{
			num = num - 3;
			count++;
		}
	
	}
	if (num < 0) cout << "-1" << endl;
	else cout << count << endl;
	return 0;
}