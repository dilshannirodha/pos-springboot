export type MeasuringUnit = 'KILO_GRAM' | 'LITER' | 'GRAM' | 'MILLI_LITER'| 'NUMBER';

export interface Item {
  itemId: number;
  itemName: string;
  measuringUnit: MeasuringUnit;
  balanceQty: number;
  supplierPrice: number;
  sellingPrice: number;
  activeState: boolean;
}
