/*
 * SPDX-License-Identifier: Apache-2.0
 */

package lsdi.hyperledger.medicalRecord;

import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.contract.ContractInterface;
import org.hyperledger.fabric.contract.annotation.Contract;
import org.hyperledger.fabric.contract.annotation.Default;
import org.hyperledger.fabric.contract.annotation.Info;
import org.hyperledger.fabric.contract.annotation.License;
import org.hyperledger.fabric.contract.annotation.Transaction;

import com.owlike.genson.Genson;

import lsdi.hyperledger.medicalRecord.assets.EvolucaoAsset;
import lsdi.hyperledger.medicalRecord.assets.MinistracaoMedicamentoAssset;
import lsdi.hyperledger.medicalRecord.assets.PrescricaoAsset;

@Contract(
        name = "medical_record",
        info = @Info(
                title = "Medical Record",
                description = "Controle de acesso em um prontuário médico",
                version = "0.0.1-SNAPSHOT",
                license = @License(
                        name = "Apache 2.0 License",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html")
        ))

@Default
public final class MedicalRecordContract implements ContractInterface {

    private final Genson genson = new Genson();

    private enum AssetTransferErrors {
        ASSET_NOT_FOUND,
        ASSET_ALREADY_EXISTS
    }

  
    @Transaction(intent = Transaction.TYPE.SUBMIT)
    public void adicionaEvolucao(Context ctx, String evolucaoJSON) {
        EvolucaoAsset evolucao = genson.deserialize(evolucaoJSON, EvolucaoAsset.class);
        String evolucaoKey = "EVOLUCAO_" + evolucao.idEvolucao;
        ctx.getStub().putStringState(evolucaoKey, genson.serialize(evolucao));
    }

    @Transaction(intent = Transaction.TYPE.SUBMIT)
    public void adicionaPrescricao(Context ctx, String prescricaoJSON) {
        PrescricaoAsset prescricao = genson.deserialize(prescricaoJSON, PrescricaoAsset.class);
        String prescricaoKey = "PRESCRICAO_" + prescricao.idPrescricao;
        ctx.getStub().putStringState(prescricaoKey, genson.serialize(prescricao));
    }

    @Transaction(intent = Transaction.TYPE.SUBMIT)
    public void ministraMedicamento(Context ctx, String ministracaoJSON) {
        MinistracaoMedicamentoAssset ministracao = genson.deserialize(ministracaoJSON, MinistracaoMedicamentoAssset.class);
        String ministracaoKey = "MINISTRACAO_" + ministracao.idMinistracao;
        ctx.getStub().putStringState(ministracaoKey, genson.serialize(ministracao));
    }

    /*@Transaction(intent = Transaction.TYPE.SUBMIT)
    public List<AssetEvolucao> listaEvolucaoPaciente(Context ctx, String idPaciente) {
        String query = String.format("{\"selector\":{\"idPaciente\":\"%s\"}}", idPaciente);
        List<AssetEvolucao> evolucoes = new ArrayList<>();

        ChaincodeStub stub = ctx.getStub();
        stub.getQueryResult(query).forEachRemaining(keyValue -> {
            AssetEvolucao evolucao = genson.deserialize(keyValue.getStringValue(), AssetEvolucao.class);
            evolucoes.add(evolucao);
        });

        return evolucoes;
    }*/

    /*@Transaction
    public List<AssetMinistracaoMedicamento> listaMinistracaoMedicamentosPaciente(Context ctx, String idPaciente) {
        String query = String.format("{\"selector\":{\"idPaciente\":\"%s\"}}", idPaciente);
        List<AssetMinistracaoMedicamento> ministracoes = new ArrayList<>();

        ChaincodeStub stub = ctx.getStub();
        stub.getQueryResult(query).forEachRemaining(keyValue -> {
            AssetMinistracaoMedicamento ministracao = genson.deserialize(keyValue.getStringValue(), AssetMinistracaoMedicamento.class);
            ministracoes.add(ministracao);
        });

        return ministracoes;
    }*/
}
