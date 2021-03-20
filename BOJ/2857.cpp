#include <iostream>
#include <string>
using namespace std;

string arr[5];
bool flag = false;
int main()
{
	for (int i = 0; i < 5; i++)
	{
		cin >> arr[i];
		int index = arr[i].find("FBI");
		if (index >= 0)
		{
			cout << i + 1 << " ";
			flag = true;
		}
	}

	if (flag == false) cout << "HE GOT AWAY!\n";
	else cout << endl;

	return 0;
}