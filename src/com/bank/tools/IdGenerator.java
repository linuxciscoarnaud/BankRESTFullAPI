/**
 * 
 */
package com.bank.tools;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.bank.constant.IDParams;

/**
 * @author Arnaud
 *
 */
public class IdGenerator implements IdentifierGenerator {

	public static final String generatorName = "bdPrimaryKays";	
	private IDParams idParams = new IDParams();
	
	/* (non-Javadoc)
	 * @see org.hibernate.id.IdentifierGenerator#generate(org.hibernate.engine.spi.SessionImplementor, java.lang.Object)
	 */
	@Override
	public Serializable generate(SessionImplementor arg0, Object arg1) throws HibernateException {
		// TODO Auto-generated method stub
		Random random = new Random();
		StringBuilder builder = new StringBuilder(idParams.getIdsLength());
		for (int i = 0; i < idParams.getIdsLength(); i++) {
			builder.append(idParams.getIdsource().charAt(random.nextInt(idParams.getIdsource().length())));
		}
		return builder.toString();
	}
}
