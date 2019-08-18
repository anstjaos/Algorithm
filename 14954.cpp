#include <iostream>
#include <vector>
using namespace std;

vector<int> save;
int input, result, temp;

int main()
{
	scanf("%d", &input);

	while (1)
	{
		if (input == 1)
		{
			printf("HAPPY\n");
			break;
		}
		
		int size = save.size();
		for (int i = 0; i < size; i++)
		{
			if (save[i] == input)
			{
				printf("UNHAPPY\n");
				return 0;
			}
		}
		save.push_back(input);
		result = 0;
		while (input != 0)
		{
			temp = input % 10;
			result += temp * temp;
			input /= 10;
		}
		input = result;
		
	}

	return 0;
}